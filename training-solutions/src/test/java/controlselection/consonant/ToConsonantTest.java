package controlselection.consonant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToConsonantTest {
    @Test
    void changeVowelsTest() {
        ToConsonant toConsonant = new ToConsonant();

        assertEquals('b', toConsonant.changeVowels('a'));
        assertEquals('c', toConsonant.changeVowels('c'));
        assertEquals('f', toConsonant.changeVowels('e'));
        assertEquals('X', toConsonant.changeVowels('X'));
        assertEquals('F', toConsonant.changeVowels('E'));
    }
}
