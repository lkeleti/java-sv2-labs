package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class ActivityTrackerMain {
    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException se) {
            throw new IllegalStateException("Can't connect to MariaDB Server", se);
        }

        ActivityRepository activityRepository = new ActivityRepository(dataSource);
//        activityRepository.saveActivity(
//                new Activity(0, LocalDateTime.of(2022,2,19,10,0), "Hiking", Type.HIKING)
//        );

        List<Activity> activities = activityRepository.listActivities();
        for (Activity activity: activities) {
            System.out.println(activityRepository.findActivityById(activity.getId()).getDescription());
        }


    }
}
