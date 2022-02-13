package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {
    /*
    CREATE TABLE activities (id BIGINT AUTO_INCREMENT PRIMARY KEY, start_time TIMESTAMP, activity_desc VARCHAR(255), activity_type VARCHAR(255));
     */
    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException se) {
            throw new IllegalStateException("Can't connect to MariaDB Server", se);
        }
        ActivityDao activityDao = new ActivityDao(dataSource);

        List<Activity> activities = new ArrayList<>();
        activities.add(
                new Activity(0, LocalDateTime.now(),"Palying basketball", Type.BASKETBALL)
        );
        activities.add(
                new Activity(0, LocalDateTime.of(2022,1,1,12,0),"Runing 10 kms", Type.RUNNING)
        );
        activities.add(
                new Activity(0, LocalDateTime.of(2022,2,13,10,0),"Biking a lot", Type.BIKING)
        );

        for (Activity activity: activities) {
            long id = activityDao.insertActivity(activity);
            activity.setId(id);
        }
    }
}
