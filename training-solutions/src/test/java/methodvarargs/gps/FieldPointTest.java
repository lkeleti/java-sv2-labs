package methodvarargs.gps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FieldPointTest {
    FieldPoint fieldPoint;
    LocalDateTime timeOfSetting;
    LocalDateTime timeOfLogging;

    @BeforeEach
    void init() {
        timeOfSetting = LocalDateTime.now();
        fieldPoint = new FieldPoint(timeOfSetting,47.573997704, 47.573997704);
    }

    @Test
    void getTimeOfSetting() {
        assertEquals( timeOfSetting, fieldPoint.getTimeOfSetting());
    }

    @Test
    void getTimeOfLoggingNull() {
        IllegalArgumentException iae =
                assertThrows(IllegalArgumentException.class,
                        () -> fieldPoint.setTimeOfLogging(null)
                        );
        assertEquals("The time of logging parameter cannot be null!", iae.getMessage());
    }

    @Test
    void getTimeOfLogging() {
        timeOfLogging = LocalDateTime.now();
        fieldPoint.setTimeOfLogging(timeOfLogging);
        assertEquals(timeOfLogging, fieldPoint.getTimeOfLogging());
    }

    @Test
    void getLatitude() {
        assertEquals(47.573997704, fieldPoint.getLatitude());
    }

    @Test
    void getLongitude() {
        assertEquals(47.573997704, fieldPoint.getLongitude());
    }
}