package algorithmstransformation.letters;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwoLettersTest {
    @Test
    void transformationTest() {
        TwoLetters twoLetters = new TwoLetters();
        List<String> words = new ArrayList<>();
        words.add("krumpli");
        words.add("cheddar sajt");
        words.add("bacon");
        words.add("vaj");
        words.add("olívaolaj");
        words.add("só");
        words.add("bors");
        List<String> transformedList = twoLetters.getFirstTwoLetters(words);

        assertEquals(7,transformedList.size());
        assertTrue(transformedList.contains("kr"));
        assertFalse(transformedList.contains("krumpli"));
        assertEquals(Arrays.asList("kr","ch","ba","va","ol","só","bo"),transformedList);
    }
}
