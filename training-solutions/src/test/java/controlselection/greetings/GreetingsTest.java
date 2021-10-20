package controlselection.greetings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingsTest {
    Greetings greetings = new Greetings();

    @Test
    void greetingsTest() {
        String result = greetings.greetingByTime(6,10);
        assertEquals("Jó reggelt!", result);

        result = greetings.greetingByTime(10,50);
        assertEquals("Jó napot!", result);

        result = greetings.greetingByTime(19,0);
        assertEquals("Jó estét!", result);

        result = greetings.greetingByTime(21,45);
        assertEquals("Jó éjt!", result);

        result = greetings.greetingByTime(4,9);
        assertEquals("Jó éjt!", result);
    }
}
