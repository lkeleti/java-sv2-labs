package controlselection.accents;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WithoutAccentsTest {
    @Test
    void removeAccentTest() {
        WithoutAccents withoutAccents = new WithoutAccents();

        assertEquals('A', withoutAccents.removeAccent('Á'));
        assertEquals('b', withoutAccents.removeAccent('b'));
        assertEquals('i', withoutAccents.removeAccent('í'));
        assertEquals('X', withoutAccents.removeAccent('X'));
        assertEquals('u', withoutAccents.removeAccent('ű'));
        assertEquals('O', withoutAccents.removeAccent('Ó'));
        assertEquals('l', withoutAccents.removeAccent('l'));
    }
}
