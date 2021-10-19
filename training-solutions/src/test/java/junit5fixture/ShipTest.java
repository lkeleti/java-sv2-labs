package junit5fixture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    Ship ship;

    @BeforeEach
    void intiTest() {
        ship = new Ship("Aquamarina", 2020, 16.51);
    }

    @Test
    void testName() {
        assertEquals("Aquamarina",ship.getName());
        assertNotEquals("Titanic", ship.getName());
    }
    @Test
    void testYearOfConstruction() {
        assertEquals(2020, ship.getYearOfConstruction());
        assertTrue(2020 == ship.getYearOfConstruction());
        assertFalse(2021 == ship.getYearOfConstruction());
    }

    @Test
    void testLength() {
        assertEquals(16.5, ship.getLength(),0.1);
    }
    @Test

    void testNull() {
        Ship anotherShip = null;
        assertNull(anotherShip);
        assertNotNull(ship);
    }

    @Test
    void testSameObjects() {
        Ship sameAsFirst = ship;
        assertSame(ship, sameAsFirst);
    }
    @Test
    void testNotSameObjects() {
        Ship differentShip = new Ship("Aquamarina", 2020, 16.51);
        assertNotSame(ship, differentShip);
    }

}
