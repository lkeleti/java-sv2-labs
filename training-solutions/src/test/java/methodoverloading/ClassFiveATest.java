package methodoverloading;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClassFiveATest {

    ClassFiveA classFiveA;
    @BeforeEach
    void init() {
        classFiveA = new ClassFiveA(Arrays.asList("One Tom","Two Joe","Three Jane","Four Paul"));
    }

    @Test
    void getTodayReferringStudent() {
        assertEquals("Two Joe", classFiveA.getTodayReferringStudent(1));
    }

    @Test
    void testGetTodayReferringStudent() {
        assertEquals("Four Paul", classFiveA.getTodayReferringStudent(Number.THREE));
    }

    @Test
    void testGetTodayReferringStudent1() {
        assertEquals("Three Jane", classFiveA.getTodayReferringStudent("TWO"));
    }
}