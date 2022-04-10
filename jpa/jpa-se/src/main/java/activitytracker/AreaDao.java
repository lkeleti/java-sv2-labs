package activitytracker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class AreaDao {
    private final EntityManagerFactory entityManagerFactory;

    public AreaDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void saveArea(Area area) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(area);
        em.getTransaction().commit();
        em.close();
    }

    public List<Area> listAllArea() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Area> areas = em.createQuery("SELECT a FROM Area a ORDER BY a.name",Area.class)
                        .getResultList();
        em.close();
        return areas;
    }

    public Area getAreaById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Area area = em.find(Area.class, id);
        em.close();
        return area;
    }
}
