package activitytracker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class ActivityTrackerMain {
    private EntityManagerFactory entityManagerFactory;

    public ActivityTrackerMain(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
        ActivityTrackerMain atm = new ActivityTrackerMain(factory);
        Activity a1 = new Activity(
                LocalDateTime.of(2022,4,4,23,46),
                "Walking",
                ActivityType.RUNNING);
        atm.saveActivity(a1);

        Activity a2 =  new Activity(
                LocalDateTime.of(2022,4,5,7,56),
                "Sleeping",
                ActivityType.BIKING);
        atm.saveActivity(a2);

        Activity a3 = new Activity(
                LocalDateTime.of(2022,4,5,9,0),
                "Working",
                ActivityType.RUNNING);
        atm.saveActivity(a3);

        System.out.println(atm.findActivityById(2L).getDescription());
        List<Activity> activities = atm.listAllActivity();
        System.out.println(activities.get(1).getDescription());
        atm.updateDescriptionById(a2.getId(),"Singing");
        System.out.println(atm.findActivityById(2L).getDescription());
        atm.deleteById(a1.getId());
        activities = atm.listAllActivity();
        System.out.println(activities.size());
    }

    public void saveActivity(Activity activity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(activity);
        em.getTransaction().commit();
        em.close();
    }

    public Activity findActivityById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Activity activity = em.find(Activity.class, id);
        em.close();
        return activity;
    }

    public List<Activity> listAllActivity() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Activity> activities = em.createQuery("SELECT a FROM Activity a ORDER BY a.description", Activity.class)
                .getResultList();
        em.close();
        return activities;
    }

    public void updateDescriptionById(Long id, String newDescription) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Activity activity = em.find(Activity.class, id);
        em.getTransaction().begin();
        activity.setDescription(newDescription);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Activity activity = em.find(Activity.class, id);
        em.getTransaction().begin();
        em.remove(activity);
        em.getTransaction().commit();
        em.close();
    }
}
