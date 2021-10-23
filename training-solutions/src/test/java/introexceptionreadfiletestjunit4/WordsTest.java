package introexceptionreadfiletestjunit4;

import introexceptionthrowjunit4.Student;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordsTest {

    @Test
    public void normalReadingTest() {
        Words words = new Words();
        assertEquals("Anna", words.getFirstWordWithA(Paths.get("src/test/resources/words.txt")));
    }

    @Test
    public void missingReadingTest() {
        Words words = new Words();
        assertEquals("A", words.getFirstWordWithA(Paths.get("src/test/resources/wordsnoa.txt")));
    }

    @Test
    public void missingFileTest() {
        Words words = new Words();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> words.getFirstWordWithA(Paths.get("src/test/resources/words_.txt")));
        assertEquals("Hiba a fájl beolvasásakor!", exception.getMessage());
    }
}
