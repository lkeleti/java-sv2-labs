package junit5fixture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordsTest {
    Words words;

    @BeforeEach
    void intiTest() {
        words = new Words();
        String[] wordArray = {"attention", "authority", "baby", "back", "bad", "bag", "base",
                "beautiful", "because", "benefit", "card", "civil", "cold", "collection", "college", "color",
                "come", "commercial", "common", "community", "day", "dead", "deal", "dog", "door", "down",
                "draw", "dream", "drive", "drop", "during", "each", "early", "east", "easy", "eat", "economic",
                "economy", "edge", "executive", "exist", "expect", "experience", "expert", "explain", "eye",
                "face", "fact"};
        for (String item: wordArray) {
            words.addWord(item);
        }
    }

    @Test
    void testGetWordsStartWith() {
        List<String> startWithFList = new ArrayList<>(Arrays.asList("face", "fact"));
        words.getWordsStartWith("f");
        assertEquals(startWithFList, words.getWords());
    }

    @Test
    void testGetWordsWithLength() {
        List<String> fixLengthList = new ArrayList<>(Arrays.asList("economic"));
        words.getWordsWithLength(8);
        assertEquals(fixLengthList, words.getWords());
    }

}
