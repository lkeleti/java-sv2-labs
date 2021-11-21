package methodchain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrasshopperTest {

    Grasshopper grasshopper;

    @BeforeEach
    void init() {
        grasshopper = new Grasshopper();
    }

    @Test
    void hopOnce() {
        assertEquals(0, grasshopper.getPosition());
        grasshopper.hopOnce(Direction.POSITIVE);
        assertEquals(1, grasshopper.getPosition());
    }

    @Test
    void moveFromZeroToThreeWithFiveHops() {
        grasshopper.moveFromZeroToThreeWithFiveHops();
        assertEquals(3, grasshopper.getPosition());
    }
}