package staticattrmeth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VetTest {
    Vet vet;
    static int code = 0;

    @BeforeEach
    void setUp() {
        vet = new Vet();
        vet.addDog(new Dog("Lassie",4,Species.ROUGH_COLLIE));
        vet.addDog(new Dog("Rin Tin Tin",1,Species.GERMAN_SHEPHERD));
        code += 2;
    }

    @Test
    void getDogsTest() {
        assertEquals(2, vet.getDogs().size());
    }

    @Test
    void addDogTest() {
        assertEquals(2, vet.getDogs().size());
        vet.addDog(new Dog("Pongo",1,Species.HOUND));
        code += 1;
        assertEquals(3, vet.getDogs().size());
    }
    @Test
    void StaticAttrTest() {
        assertEquals(code, vet.getDogs().get(1).getCodeNumber());
        vet.addDog(new Dog("Jerry Lee",1,Species.GERMAN_SHEPHERD));
        code += 1;
        assertEquals(code, vet.getDogs().get(2).getCodeNumber());
    }
}