package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    List<Activity> activities;
    ActivityDao activityDao;

    @BeforeEach
    void init() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException se) {
            throw new IllegalStateException("Can't connect to MariaDB Server", se);
        }
        activityDao = new ActivityDao(dataSource);
        Flyway flyway = Flyway.configure().locations("db/migration/activitytracker").dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        activities = new ArrayList<>();
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
            activity.addTrackPoint(new TrackPoint(0, LocalDate.now(), 10, 10));
            activity.addTrackPoint(new TrackPoint(0, LocalDate.now(), 20, 30));
            activity.addTrackPoint(new TrackPoint(0, LocalDate.now(), 20, 40));
        }
    }

    @Test
    void saveActivityTest() {
        for (Activity activity: activities) {
            activityDao.saveActivity(activity);
        }
        assertEquals(activities.get(0).getDesc(), activityDao.findActivityById(1).getDesc());
    }

    @Test
    void findActivityByIdTest() {
        for (Activity activity: activities) {
            activityDao.saveActivity(activity);
        }

        Activity activity = activityDao.findActivityById(2);
        assertEquals("Runing 10 kms", activity.getDesc());
    }

    @Test
    void listActivitiesTest() {
        for (Activity activity: activities) {
            activityDao.saveActivity(activity);
        }

        List<Activity> activitiesResult = activityDao.listActivities();
        assertEquals(3, activitiesResult.size());
    }
}