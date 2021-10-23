package controladvanced.labels;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class LabelsTest {
    @Test
    public void getTableOfNumbersTest () {
        Labels labels = new Labels();

        System.out.println(Arrays.deepToString(labels.getTableOfNumbers(10)));
        assertEquals(2, labels.getTableOfNumbers(10)[0][0]);
        assertEquals(12, labels.getTableOfNumbers(10)[1][9]);
    }
}
