package introexceptionthrowjunit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TankTest {
    @Test
    public void createTankNormal() {
        Tank tank = new Tank();
        tank.modifyAngle(80);

        int maxRight = tank.getAngle();
        assertEquals(80, maxRight);
    }

        @Test(expected = IllegalArgumentException.class)
    public void testAngleTooMuch() {
            Tank tank = new Tank();
            tank.modifyAngle(100);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testAngleTooMuchRule() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid angle!");
        Tank tank = new Tank();
        tank.modifyAngle(100);
    }

    @Test
    public void testAngleTooMuchAssertThrows() {
        Tank tank = new Tank();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> tank.modifyAngle(100));
        assertEquals("Invalid angle!", exception.getMessage());
    }
}
