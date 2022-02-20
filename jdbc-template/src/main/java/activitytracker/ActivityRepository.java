package activitytracker;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ActivityRepository {
    private JdbcTemplate jdbcTemplate;

    public ActivityRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

//    public void saveActivity(Activity activity) {
//        jdbcTemplate.update("INSERT INTO `activities` (`start_time`, `activity_desc`, `activity_type`) VALUES(?,?,?)",
//                Timestamp.valueOf(activity.getStartTime()), activity.getDescription(), activity.getType().toString());
//    }

    public Activity saveActivity(Activity activity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> getKeyAfterInsert(activity, conn), keyHolder);
        long id = keyHolder.getKey().longValue();
        activity.setId(id);
        saveTrackPoints(id, activity.getTrackPoints());
        return activity;
    }

    private PreparedStatement getKeyAfterInsert(Activity activity, Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO `activities` (`start_time`, `activity_desc`, `activity_type`) VALUES(?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        ps.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
        ps.setString(2, activity.getDescription());
        ps.setString(3, activity.getType().toString());
        return ps;
    }

    @Transactional
    public void saveTrackPoints(long activityId, List<TrackPoint> trakpoints) {
        for (TrackPoint trackPoint : trakpoints) {
            if (trackPoint.getLat() > 90 || trackPoint.getLat() < -90 || trackPoint.getLon() > 180 || trackPoint.getLon() < -180) {
                throw new IllegalArgumentException("Invalid latitude or longitude value!");
            }
            jdbcTemplate.update("INSERT INTO `trackpoints` (activity_id, track_time, lat, lon) VALUES(?,?,?,?)",
                    activityId, Timestamp.valueOf(LocalDateTime.of(trackPoint.getTime(), LocalTime.NOON)), trackPoint.getLat(), trackPoint.getLon());
        }
    }

    public List<Activity> listActivities() {
        return jdbcTemplate.query("SELECT * FROM `activities`", (rs, i) -> new Activity(rs.getLong("id"), rs.getTimestamp("start_time").toLocalDateTime(), rs.getString("activity_desc"), Type.valueOf(rs.getString("activity_type"))));
    }

    public Activity findActivityById(long id) {
        List<TrackPoint> trackPoints = findTrackPointsById(id);
        return jdbcTemplate.queryForObject("SELECT * FROM `activities` WHERE id = ?", (rs, i) -> new Activity(rs.getLong("id"), rs.getTimestamp("start_time").toLocalDateTime(), rs.getString("activity_desc"), Type.valueOf(rs.getString("activity_type")), trackPoints), id);
    }


    public List<TrackPoint> findTrackPointsById(long id) {
        return jdbcTemplate.query("SELECT * FROM `trackpoints` WHERE activity_id = ?",
        (rs, i) -> new TrackPoint(rs.getLong("id"), rs.getTimestamp("track_time").toLocalDateTime().toLocalDate(),
                rs.getDouble("lat"), rs.getDouble("lon")), id
        );
    }
}
