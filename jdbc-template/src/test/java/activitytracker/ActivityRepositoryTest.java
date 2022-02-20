package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityRepositoryTest {
    MariaDbDataSource dataSource;
    List<Activity> activities = new ArrayList<>();
    ActivityRepository activityRepository;

    @BeforeEach
    void setUp() {
        dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUserName("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can't connect to database", sqle);
        }
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        activityRepository = new ActivityRepository(dataSource);

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
        List<Activity> result = new ArrayList<>();
        for (Activity activity: activities) {
            result.add(activityRepository.saveActivity(activity));
        }
        assertEquals(3, result.size());
        assertEquals(activities.get(0).getDescription(), result.get(0).getDescription());
        assertEquals(1, result.get(0).getId());
    }

    @Test
    void listActivitiesTest() {
        for (Activity activity: activities) {
            activity = activityRepository.saveActivity(activity);
        }
        List<Activity> result = activityRepository.listActivities();
        assertEquals("Palying basketball", activityRepository.listActivities().get(0).getDescription());
    }

    @Test
    void findActivityByIdTest() {
        for (Activity activity: activities) {
            activityRepository.saveActivity(activity);
        }
        assertEquals("Palying basketball", activityRepository.findActivityById(1).getDescription());
    }

    @Test
    void findActivityByIdInvalidTest() {
        for (Activity activity: activities) {
            activityRepository.saveActivity(activity);
        }
        Exception e =  assertThrows(EmptyResultDataAccessException.class, ()->
                activityRepository.findActivityById(10).getDescription()
        );

        assertEquals("Incorrect result size: expected 1, actual 0", e.getMessage());
    }

    @Test
    void saveInvalidTrackPointsTest() {
        for (Activity activity: activities) {
            activity = activityRepository.saveActivity(activity);
        }
        activities.get(0).addTrackPoint(new TrackPoint(1, LocalDate.now(), 200, 200));
        assertEquals(3, activityRepository.findTrackPointsById(1).size());
    }
}