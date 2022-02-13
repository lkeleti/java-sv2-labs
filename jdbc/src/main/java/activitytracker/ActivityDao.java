package activitytracker;

import javax.sql.DataSource;
import java.sql.*;

public class ActivityDao {
    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long insertActivity(Activity activity) {
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
}
