package staticattrmeth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {
    Dog dog;

    @BeforeEach
    void init() {
        dog = new Dog("Lassie",4,Species.ROUGH_COLLIE);
    }
    @Test
    void getNameTest() {
        assertEquals("Lassie", dog.getName());
    }

    @Test
    void getAgeTest() {
        assertEquals(4, dog.getAge());
    }

    @Test
    void getASpeciesTest() {
        assertEquals(Species.ROUGH_COLLIE, dog.getSpecies());
    }

    @Test
    void setCodeNumberTest() {
        dog.setCodeNumber(1);
        assertEquals(1, dog.getCodeNumber());
    }
}