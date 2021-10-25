package algorithmsfilter.prefix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrefixTest {
    @Test
    void FilteredListTest() {
       Prefix prefix = new Prefix();
        List<String> words = Arrays.asList("amper", "amőba", "volt", "bamba");
        assertEquals(2, prefix.getWordsStartWith(words,"am").size());
        assertEquals(Arrays.asList("amper","amőba").toString(), prefix.getWordsStartWith(words,"am").toString());
        assertTrue(prefix.getWordsStartWith(words,"am").contains("amper"));
        assertFalse(prefix.getWordsStartWith(words,"am").contains("bamba"));
    }
}
