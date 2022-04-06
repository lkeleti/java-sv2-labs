package activitytracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    ActivityDao activityDao;

    @BeforeEach
     void setUp() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
        activityDao = new ActivityDao(factory);

        Activity a1 = new Activity(
                LocalDateTime.of(2022,4,4,23,46),
                "Walking",
                ActivityType.RUNNING);
        activityDao.saveActivity(a1);

        Activity a2 =  new Activity(
                LocalDateTime.of(2022,4,5,7,56),
                "Sleeping",
                ActivityType.BIKING);
        activityDao.saveActivity(a2);

        Activity a3 = new Activity(
                LocalDateTime.of(2022,4,5,9,0),
                "Working",
                ActivityType.RUNNING);
        activityDao.saveActivity(a3);
    }

    @Test
    void saveActivityTest() {
        Activity a4 = new Activity(
                LocalDateTime.of(2022,4,5,9,0),
                "Working",
                ActivityType.RUNNING);
        activityDao.saveActivity(a4);
        List<Activity> activities = activityDao.listActivities();
        assertEquals(4, activities.size());
    }

    @Test
    void listActivitiesTest() {
        List<Activity> activities = activityDao.listActivities();
        assertEquals(3, activities.size());
    }

    @Test
    void findActivityByIdTest() {
        List<Activity> activities = activityDao.listActivities();
        Long id = activities.get(0).getId();
        Activity activity = activityDao.findActivityById(id);
        assertEquals(activities.get(0).getDescription(), activity.getDescription());
    }

    @Test
    void deleteActivityTest() {
        List<Activity> activities = activityDao.listActivities();
        Long id = activities.get(0).getId();
        activityDao.deleteActivity(id);
        activities = activityDao.listActivities();
        assertEquals(2, activities.size());
    }

    @Test
    void updateActivityTest() {
        Activity activity = new Activity(
                LocalDateTime.of(2022,4,4,23,46),
                "Before sleeping",
                ActivityType.RUNNING);
        activityDao.saveActivity(activity);
        Long id = activity.getId();
        activityDao.updateActivity(id, "Updated");
        Activity activityFromDb = activityDao.findActivityById(id);
        assertEquals("Updated", activityFromDb.getDescription());
    }
}