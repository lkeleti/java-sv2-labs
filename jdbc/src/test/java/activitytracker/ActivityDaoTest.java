package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
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
        assertEquals(3, activity.getTrackPoints().size());
    }

    @Test
    void listActivitiesTest() {
        for (Activity activity: activities) {
            activityDao.saveActivity(activity);
        }

        List<Activity> activitiesResult = activityDao.listActivities();
        assertEquals(3, activitiesResult.size());
        assertEquals(3, activitiesResult.get(1).getTrackPoints().size());
    }

    @Test
    void saveImageToActivityTest() {
        for (Activity activity: activities) {
            activityDao.saveActivity(activity);
        }

        List<Activity> activitiesResult = activityDao.listActivities();
        try{
            byte[] image1 = Files.readAllBytes(Path.of("src/main/resources/images/basket-ball.png"));
            activitiesResult.get(0).setImage(new Image(0, "basket-ball.png", image1));
            byte[] image2 = Files.readAllBytes(Path.of("src/main/resources/images/run.png"));
            activitiesResult.get(1).setImage(new Image(0, "run.png", image2));
            byte[] image3 = Files.readAllBytes(Path.of("src/main/resources/images/stretching.png"));
            activitiesResult.get(2).setImage(new Image(0, "stretching.png", image3));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read image", ioe);
        }

        for (Activity activity: activitiesResult) {
            activityDao.saveImageToActivity(activity.getId(), activity.getImage());
        }
    }
    @Test
    void loadImageToActivityTest() {
        for (Activity activity: activities) {
            activityDao.saveActivity(activity);
        }
        List<Activity> activitiesResult = activityDao.listActivities();
        try{
            byte[] image1 = Files.readAllBytes(Path.of("src/main/resources/images/basket-ball.png"));
            activitiesResult.get(0).setImage(new Image(0, "basket-ball.png", image1));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read image", ioe);
        }

        activityDao.saveImageToActivity(activitiesResult.get(0).getId(), activitiesResult.get(0).getImage());

        Image image = activityDao.loadImageToActivity(1,"basket-ball.png");
        assertEquals(20539, image.getContent().length);
        try {
            Files.write(Path.of("src/main/resources/images/basket-ball_1.png"), image.getContent());
        } catch (IOException ioe) {
            throw new IllegalStateException("Cam't write to file.", ioe);
        }
    }
}