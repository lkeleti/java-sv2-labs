package lambdaoptional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class ClubTest {
    Club club;

    @BeforeEach
    void init() {
        club = new Club(
                new ArrayList<>(Arrays.asList(
                        new Member("John Doe", Arrays.asList("Can do one thing", "Can do two thing"), Gender.MALE),
                        new Member("Jack Doe", Arrays.asList("Can do one thing"), Gender.MALE),
                        new Member("Jane Doe", Arrays.asList("Can do one thing", "Can do two thing", "Can do three thing"), Gender.FEMALE),
                        new Member("Joe Doe", Arrays.asList("Can do one thing", "Can do two thing", "Can do anything"), Gender.MALE)
                ))
        );
    }

    @Test
    void averageNumberOfSkills() {
        assertEquals(2.25, club.averageNumberOfSkills().get());
    }

    @Test
    void findFirstNameTest() {
        assertEquals("John Doe", club.findFirst(
                member -> member.getName().equals("John Doe")
                ).get().getName()
        );
    }

    @Test
    void findFirstFemaleTest() {
        assertEquals("Jane Doe", club.findFirst(
                member -> member.getGender() == Gender.FEMALE
                ).get().getName()
        );
    }

    @Test
    void notFindFirstNameTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> club.findFirst(
                        member -> member.getName().equals("John Lennon")
                )
        );

        assertEquals("Cannot find flat applied to the condition.", iae.getMessage());
    }

    @Test
    void FindFirstNameEmptyTest() {
        assertEquals(Optional.empty(), new Club(null).findFirst(
                member -> member.getName().equals("John Doe")
        ));
    }

    @Test
    void findFirstCanDoThreeTest() {
        assertEquals("Jane Doe", club.findFirst(
                        member -> member.getSkills().size() >= 3
                ).get().getName()
        );
    }

    @Test
    void findFirstCanDoAnythingTest() {
        assertEquals("Joe Doe", club.findFirst(
                        member -> member.getSkills().contains("Can do anything")
                ).get().getName()
        );
    }
}