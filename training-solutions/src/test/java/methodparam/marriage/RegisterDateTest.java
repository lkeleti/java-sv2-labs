package methodparam.marriage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RegisterDateTest {
    RegisterDate registerDate;

    @BeforeEach
    void setUp() {
        registerDate = new RegisterDate("teszt eset", LocalDate.of(2021,11,21));
    }

    @Test
    void getDescription() {
        assertEquals("teszt eset", registerDate.getDescription());
    }

    @Test
    void getDate() {
        assertEquals(LocalDate.of(2021,11,21), registerDate.getDate());
    }
}