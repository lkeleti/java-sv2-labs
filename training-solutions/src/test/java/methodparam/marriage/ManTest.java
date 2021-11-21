package methodparam.marriage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ManTest {

    Man man;
    @BeforeEach
    void setUp() {
        man = new Man("Móra Ferenc", LocalDate.of(1879,7,19));
    }

    @Test
    void getName() {
        assertEquals("Móra Ferenc", man.getName());
    }

    @Test
    void getRegisterDates() {
        assertEquals(1,man.getRegisterDates().size());
        assertEquals(LocalDate.of(1879,7,19),man.getRegisterDates().get(0).getDate());
        assertEquals("születés ideje",man.getRegisterDates().get(0).getDescription());
    }

    @Test
    void addRegisterDate() {
        man.addRegisterDate(new RegisterDate("iskola kezdés",LocalDate.of(1886,9,1)));

        assertEquals(2,man.getRegisterDates().size());
        assertEquals(LocalDate.of(1879,7,19),man.getRegisterDates().get(0).getDate());
        assertEquals(LocalDate.of(1886,9,1),man.getRegisterDates().get(1).getDate());
        assertEquals("születés ideje",man.getRegisterDates().get(0).getDescription());
    }
}