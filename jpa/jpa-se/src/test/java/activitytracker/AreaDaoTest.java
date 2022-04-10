package activitytracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AreaDaoTest {
    private AreaDao areaDao;

    @BeforeEach
    void setUp() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
        areaDao = new AreaDao(factory);
        Area area1 = new Area("JNSZ");
        Area area2 = new Area("BP");
        Area area3 = new Area("BKK");
        areaDao.saveArea(area1);
        areaDao.saveArea(area2);
        areaDao.saveArea(area3);
    }

    @Test
    void saveAreaTest() {
        assertEquals(3, areaDao.listAllArea().size());
    }
}
