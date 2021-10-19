package junit5assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DragonTest {
    @Test
    void testName() {
       Dragon dragon = new Dragon("Paff", 1, 3.3);
        assertEquals("Paff", dragon.getName());
        assertNotEquals("Süsü", dragon.getName());
    }
    @Test
    void testNumberOfHeads() {
        Dragon dragon = new Dragon("Paff", 1, 3.3);
        assertEquals( 1, dragon.getNumberOfHeads());
        assertTrue(dragon.getNumberOfHeads() == 1);
        assertFalse(dragon.getNumberOfHeads() == 0);
    }
    @Test
    void testHeight() {
        Dragon dragon = new Dragon("Paff", 1, 3.3);
        assertEquals(3.3, dragon.getHeight(),0.0000001);
    }

    @Test
    void testNull() {
        Dragon dragon = new Dragon("Paff", 1, 3.3);
        Dragon anotherDragon = null;
        assertNull(anotherDragon);
        assertNotNull(dragon);
    }

    @Test
    void testSameObjects() {
        Dragon dragon = new Dragon("Paff", 1, 3.3);
        Dragon anotherDragon = dragon;

        assertSame(dragon,anotherDragon);
    }

    @Test
    void testNotSameObjects() {
        Dragon dragon = new Dragon("Paff", 1, 3.3);
        Dragon anotherDragon = new Dragon("Paff", 1, 3.3);

        assertNotSame(dragon, anotherDragon);
    }
}
