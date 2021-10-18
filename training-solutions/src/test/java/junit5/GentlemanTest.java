package junit5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GentlemanTest {

    @Test
    void testCreate() {
        //Given
        Gentleman gentleman = new Gentleman();

        //When
        String greeting = gentleman.sayHello("John Doe");

        //Then
        assertEquals("Hello John Doe!", greeting);

        //When
        greeting = gentleman.sayHello(null);

        //Then
        assertEquals("Hello Anonymous!", greeting);

    }
}
