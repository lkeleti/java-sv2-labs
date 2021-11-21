package methodparam.marriage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WomanTest {
    Woman woman;

    @BeforeEach
    void setUp() {
        woman = new Woman("Walleshausen Ilona", LocalDate.of(1880,5,5));
    }

    @Test
    void getName() {
        assertEquals("Walleshausen Ilona", woman.getName());
    }

    @Test
    void setName() {
        woman.setName("Móra Ferencné");
        assertEquals("Móra Ferencné", woman.getName());
    }

    @Test
    void getRegisterDates() {
        assertEquals(LocalDate.of(1880,5,5),woman.getRegisterDates().get(0).getDate());
    }

    @Test
    void addRegisterDate() {
        woman.addRegisterDate(new RegisterDate("iskola kezdés",LocalDate.of(1887,9,1)));

        assertEquals(2,woman.getRegisterDates().size());
        assertEquals(LocalDate.of(1880,5,5),woman.getRegisterDates().get(0).getDate());
        assertEquals(LocalDate.of(1887,9,1),woman.getRegisterDates().get(1).getDate());
        assertEquals("születés ideje",woman.getRegisterDates().get(0).getDescription());
    }
}