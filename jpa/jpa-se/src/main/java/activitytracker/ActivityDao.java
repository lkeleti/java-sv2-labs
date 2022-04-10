package activitytracker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ActivityDao {

    private final EntityManagerFactory entityManagerFactory;

    public ActivityDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void saveActivity(Activity activity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(activity);
        em.getTransaction().commit();
    }

    public List<Activity> listActivities() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Activity> activities = em.createQuery("SELECT a FROM Activity a ORDER BY a.description", Activity.class)
                .getResultList();
        em.close();
        return activities;
    }

    public Activity findActivityById(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Activity activity = em.find(Activity.class, id);
        em.close();
        return activity;
    }

    public void deleteActivity(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Activity activity = em.find(Activity.class, id);
        em.getTransaction().begin();
        em.remove(activity);
        em.getTransaction().commit();
        em.close();
    }

    public void updateActivity(long id, String description) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Activity activity = em.find(Activity.class, id);
        em.getTransaction().begin();
        activity.setDescription(description);
        em.getTransaction().commit();
        em.close();
    }

    public Activity findActivityByIdWithLabels(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Activity activity = em.createQuery("SELECT a FROM Activity a JOIN FETCH a.labels WHERE a.id =:id ORDER BY a.description", Activity.class)
                .setParameter("id", id)
                .getSingleResult();
        em.close();
        return activity;
    }

    public Activity findActivityByIdWithTrackPoints(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Activity activity = em.createQuery("SELECT a FROM Activity a JOIN FETCH a.trackPoints WHERE a.id =:id ORDER BY a.description", Activity.class)
                .setParameter("id", id)
                .getSingleResult();
        em.close();
        return activity;
    }

    public Activity findActivityByIdWithAreas(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Activity activity = em.createQuery("SELECT a FROM Activity a JOIN FETCH a.areas WHERE a.id =:id ORDER BY a.description", Activity.class)
                .setParameter("id", id)
                .getSingleResult();
        em.close();
        return activity;
    }
}
