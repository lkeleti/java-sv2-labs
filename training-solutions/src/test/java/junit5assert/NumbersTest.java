package junit5assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NumbersTest {

    @Test
    void testGetEvenNumbers() {
        Numbers numbers = new Numbers();
        int[] testNumbers = {2, 8, 5, 6, 2, 3, 9};
        int[] expectedResult = {2, 8, 0, 6, 2, 0, 0};
        int[] resultNumbers = numbers.getEvenNumbers(testNumbers);
        assertArrayEquals(expectedResult, resultNumbers);
    }
}
