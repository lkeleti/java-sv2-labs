package methodchain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifiedWordTest {

    @Test
    void modify() {
        ModifiedWord modifiedWord = new ModifiedWord();
        assertEquals("AxMy", modifiedWord.modify("alma"));
        assertEquals("KxRy", modifiedWord.modify("körte"));
        assertEquals("SxIy", modifiedWord.modify("szilva"));
    }
}