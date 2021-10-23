package introexceptionthrowjunit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {
    @Test
    void normalOperation() {
        Student student = new Student();
        student.addNote(5);
        assertEquals(5, student.getGrades().get(0));
    }

    @Test
    void badOperation() {
        Student student = new Student();
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> student.addNote(6));
        assertEquals("Note must be between 1 and 5!", iae.getMessage());
    }
}
