package methodparam.marriage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MarriageTest {

    @Test
    void getMarried() {
        Woman woman = new Woman("Walleshausen Ilona", LocalDate.of(1880,5,5));
        Man man = new Man("Móra Ferenc", LocalDate.of(1879,7,19));

        Marriage marriage = new Marriage();
        marriage.getMarried(woman, man);

        assertEquals(LocalDate.now(), man.getRegisterDates().get(1).getDate());
        assertEquals(LocalDate.now(), woman.getRegisterDates().get(1).getDate());

        assertEquals("házasságkötés ideje", man.getRegisterDates().get(1).getDescription());
        assertEquals("házasságkötés ideje", woman.getRegisterDates().get(1).getDescription());

        assertEquals("Móra Ferencné", woman.getName());
    }
}