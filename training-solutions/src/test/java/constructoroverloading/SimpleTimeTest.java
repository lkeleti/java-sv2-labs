package constructoroverloading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleTimeTest {

    @Test
    void constructorsTest() {
        SimpleTime simpleTime = new SimpleTime(10,50);
        assertEquals(10, simpleTime.getHours());
        assertEquals(50, simpleTime.getMinutes());

        simpleTime = new SimpleTime(11);
        assertEquals(11, simpleTime.getHours());
        assertEquals(0, simpleTime.getMinutes());

        simpleTime = new SimpleTime(new SimpleTime(20,40));
        assertEquals(20, simpleTime.getHours());
        assertEquals(40, simpleTime.getMinutes());
    }
}
