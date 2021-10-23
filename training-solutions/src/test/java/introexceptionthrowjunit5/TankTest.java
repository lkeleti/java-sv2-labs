package introexceptionthrowjunit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TankTest {

    @Test
    void normalOperation() {
        Tank tank = new Tank();
        tank.modifyAngle(20);
        assertEquals(20, tank.getAngle());
    }
    @Test
    void badOperation() {
        Tank tank = new Tank();
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> tank.modifyAngle(120));
        assertEquals("Invalid angle!", iae.getMessage());
    }
}
