package defaultconstructor.date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DateTest {
    private SimpleDate simpleDate = null;

    @BeforeEach
    void initDate() {
        simpleDate = new SimpleDate();
    }

    @AfterEach
    void destroyDate() {
        simpleDate = null;
    }
    @Test
    void isCorrect() {
        simpleDate.setDate(2021,11,1);
        assertEquals(2021, simpleDate.getYear());
    }

    @Test
    void isIncorrect() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> simpleDate.setDate(2021,2,29));
        assertEquals("One or more given parameter cannot be applied! 2021, 2, 29", exception.getMessage());
    }

    @Test
    void isLeapYear() {
        simpleDate.setDate(2008,2,29);
        assertEquals(29, simpleDate.getDay());
    }

    @Test
    void isNotLeapYear() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> simpleDate.setDate(2100,2,29));
    }

    @Test
    void calculateMonthLength() {
        simpleDate.setDate(2021,12,31);
        assertEquals(31, simpleDate.getDay());
    }

    @Test
    void incorrectMonthLength() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> simpleDate.setDate(2021,4,31));
    }
}
