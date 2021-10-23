package introexceptionthrowjunit4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentTest {

    @Test
    public void createStudentNormal() {
        Student student = new Student();
        student.addNote(5);

        int firstGrade = student.getGrades().get(0);
        assertEquals(5, firstGrade);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateWithGradeZero() {
        Student student = new Student();
        student.addNote(0);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCreateWithZeroGradeRule() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Note must be between 1 and 5!");
        Student student = new Student();
        student.addNote(0);
    }

    @Test
    public void testCreateWithZeroGradeAssertThrows() {
        Student student = new Student();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> student.addNote(0));
        assertEquals("Note must be between 1 and 5!", exception.getMessage());
    }
}
