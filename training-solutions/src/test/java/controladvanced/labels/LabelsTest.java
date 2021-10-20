package controladvanced.labels;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LabelsTest {
    @Test
    void getTableOfNumbersTest () {
        Labels labels = new Labels();

        System.out.println(Arrays.deepToString(labels.getTableOfNumbers(10)));
        assertEquals(2, labels.getTableOfNumbers(10)[0][0]);
        assertEquals(12, labels.getTableOfNumbers(10)[1][9]);
    }
}
