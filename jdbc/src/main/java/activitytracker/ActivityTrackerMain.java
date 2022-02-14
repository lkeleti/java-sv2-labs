package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
            long id = activityDao.saveActivity(activity);
            activity.setId(id);
        }

        Activity activity = activityDao.findActivityById(1);
        System.out.println(activity.getDesc());
        List<Activity> activityList = activityDao.listActivities();
        System.out.println(activityList);
    }
}
