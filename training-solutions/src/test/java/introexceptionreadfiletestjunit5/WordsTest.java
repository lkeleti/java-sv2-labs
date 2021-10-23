package introexceptionreadfiletestjunit5;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordsTest {
    @Test
    void normalReadingTest() {
        Words words = new Words();
        assertEquals("Anna", words.getFirstWordWithA(Paths.get("src/test/resources/words.txt")));
    }

    @Test
    void missingReadingTest() {
        Words words = new Words();
        assertEquals("A", words.getFirstWordWithA(Paths.get("src/test/resources/wordsnoa.txt")));
    }

    @Test
    void missingFileTest() {
        Words words = new Words();
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> words.getFirstWordWithA(Paths.get("src/test/resources/words_.txt")));
        assertEquals("Hiba a fájl beolvasásakor!", iae.getMessage());
    }

}
