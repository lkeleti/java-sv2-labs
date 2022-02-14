package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {
    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long saveActivity(Activity activity) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO activities (start_time, activity_desc, activity_type) VALUES(?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
        ) {
            pstmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            pstmt.setString(2, activity.getDesc());
            pstmt.setString(3, activity.getType().toString());
            pstmt.executeUpdate();
            long id = getIdByStatement(pstmt);
            saveTrackPoints(activity, dataSource, id);
            return id;
        } catch (SQLException se) {
            throw new IllegalStateException("Can't insert data.", se);
        }
    }

    private void saveTrackPoints(Activity activity, DataSource dataSource, long id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO trackpoints ( activity_id, track_time, lat, lon) VALUES(?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
        ) {
            conn.setAutoCommit(false);
            saveTrackPointByStatement(activity, id, conn, pstmt);
            conn.setAutoCommit(true);
        } catch (SQLException se) {
            throw new IllegalStateException("Can't INSERT TrackPoints", se);
        }

    }

    private void saveTrackPointByStatement(Activity activity, long id, Connection conn, PreparedStatement pstmt) throws SQLException {
        try {
            List<Long> tpIds = new ArrayList<>();
            for (TrackPoint trackPoint : activity.getTrackPoints()) {
                pstmt.setLong(1, id);
                pstmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(trackPoint.getTime(), LocalTime.NOON)));
                pstmt.setDouble(3, trackPoint.getLat());
                pstmt.setDouble(4, trackPoint.getLon());
                validateLatAndLon(trackPoint.getLat(), trackPoint.getLon());
                pstmt.executeUpdate();
                getTrackPointIdByStatement(pstmt, tpIds);
            }
            conn.commit();
            List<TrackPoint> tps = activity.getTrackPoints();
            for (int i = 0; i < tps.size(); i++) {
                tps.get(i).setId(tpIds.get(i));
            }
        } catch (IllegalArgumentException iae) {
            conn.rollback();
        }
    }

    private void getTrackPointIdByStatement(PreparedStatement pstmt, List<Long> tpIds) {
        try (ResultSet rs = pstmt.getGeneratedKeys()) {
            if (rs.next()) {
                tpIds.add(rs.getLong(1));
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Can't retrive TrackPoint id", se);
        }
    }

    private void validateLatAndLon(double lat, double lon) {
        if (lat < -90 || lat > 90 || lon < -180 || lon > 180) {
            throw new IllegalArgumentException("Latitude or Longitude value is out of range.");
        }
    }

    private long getIdByStatement(PreparedStatement pstmt) {
        try (
                ResultSet rs = pstmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getLong(1);
            }
            throw new IllegalStateException("Can't get ID!");
        } catch (SQLException se) {
            throw new IllegalStateException("Can't get generated key!", se);
        }
    }

    public Activity findActivityById(long id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM activities WHERE id = ?");

        ) {
            pstmt.setLong(1, id);
            return getActivity(id, pstmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Can't execute SELECT");
        }
    }

    private Activity getActivity(long id, PreparedStatement pstmt) throws SQLException {
        try (
                ResultSet rs = pstmt.executeQuery();
        ) {
            if (rs.next()) {
                return new Activity(rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        Type.valueOf(rs.getString("activity_type")));
            }
            throw new IllegalArgumentException("Can't find specified id: " + id);
        }
    }

    public List<Activity> listActivities() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            stmt.executeQuery("SELECT * FROM activities");
            return getActivitiesByStatement(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Can't execute SELECT");
        }
    }

    private List<Activity> getActivitiesByStatement(Statement stmt) throws SQLException {
        List<Activity> activities = new ArrayList<>();
        try (ResultSet rs = stmt.getResultSet()) {
            while (rs.next()) {
                activities.add(
                        new Activity(
                                rs.getLong("id"),
                                rs.getTimestamp("start_time").toLocalDateTime(),
                                rs.getString("activity_desc"),
                                Type.valueOf(rs.getString("activity_type"))
                        )
                );
            }
            return activities;
        }
    }
}
