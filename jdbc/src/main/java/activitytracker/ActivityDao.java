package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
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
            return getIdByStatement(pstmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Can't insert data.", se);
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
            pstmt.setLong(1,id);
            return getActivity(id, pstmt);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can't execute SELECT");
        }
    }

    private Activity getActivity(long id, PreparedStatement pstmt) throws SQLException {
        try (
                ResultSet rs = pstmt.executeQuery();
        )
        {
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
            return GetActivitiesByStatement(stmt);
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can't execute SELECT");
        }
    }

    private List<Activity> GetActivitiesByStatement(Statement stmt) throws SQLException {
        List<Activity> activities = new ArrayList<>();
        try (ResultSet rs = stmt.getResultSet())
        {
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
