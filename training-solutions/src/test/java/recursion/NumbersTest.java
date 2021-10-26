package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersTest {
    @Test
    void getSumTest() {
        Numbers numbers = new Numbers();
        assertEquals(6,numbers.getSum(new int[]{1,2,3}));
        assertEquals(210,numbers.getSum(new int[]{10,20,30,40,50,60}));

        assertEquals(10, numbers.getSum(new int[]{1, 2, 3, 4}));
        assertEquals(2, numbers.getSum(new int[]{2}));
        assertEquals(0, numbers.getSum(new int[]{}));
    }
}
