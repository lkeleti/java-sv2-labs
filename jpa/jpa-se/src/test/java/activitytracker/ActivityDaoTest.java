package activitytracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    ActivityDao activityDao;
    AreaDao areaDao;

    @BeforeEach
     void setUp() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
        activityDao = new ActivityDao(factory);
        areaDao = new AreaDao(factory);

        Activity a1 = new Activity(
                LocalDateTime.of(2022,4,4,23,46),
                "Walking",
                ActivityType.RUNNING);
        a1.addLabel("Nagy túra");
        a1.addLabel("Kint a természetben");
        a1.addTrackPoint(new TrackPoint(LocalDate.of(2022,4,5),1,1));
        a1.addTrackPoint(new TrackPoint(LocalDate.of(2022,4,1),2,2));
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

    @Test
    void findActivityByIdWithLabelsTest() {
        List<Activity> activities = activityDao.listActivities();
        Long id = activities.get(1).getId();
        Activity activity = activityDao.findActivityByIdWithLabels(id);
        assertEquals(2, activity.getLabels().size());
    }

    @Test
    void findActivityByIdWithTrackPointsTest() {
        List<Activity> activities = activityDao.listActivities();
        Long id = activities.get(1).getId();
        Activity activityReadBack = activityDao.findActivityByIdWithTrackPoints(id);
        assertEquals(2, activityReadBack.getTrackPoints().size());
        assertEquals(2, activityReadBack.getTrackPoints().get(0).getLat());
    }

    @Test
    void updateActivityWithArea() {
        Area area1 = new Area("JNSZ");
        Area area2 = new Area("BP");
        Area area3 = new Area("BKK");

        Activity a1 = new Activity(
                LocalDateTime.of(2022,4,8,12,0),
                "Singing",
                ActivityType.RUNNING);

        activityDao.saveActivity(a1);

        Activity a2 = new Activity(
                LocalDateTime.of(2022,4,10,18,0),
                "Dancing",
                ActivityType.RUNNING);

        activityDao.saveActivity(a2);

        area1.addActivity(a1);
        area2.addActivity(a1);

        area2.addActivity(a2);
        area3.addActivity(a2);

        areaDao.saveArea(area1);
        areaDao.saveArea(area2);
        areaDao.saveArea(area3);

        assertEquals(2, activityDao.findActivityByIdWithAreas(a1.getId()).getAreas().size());
    }
}