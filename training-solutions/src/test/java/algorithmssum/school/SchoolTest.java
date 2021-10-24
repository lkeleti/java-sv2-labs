package algorithmssum.school;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SchoolTest {

    @Test
    void sumOfHeadcountTest() {
        int sumOfHeadcount = new School().getNumberOfStudents(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        assertEquals(55,sumOfHeadcount);
    }
}
