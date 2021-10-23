package introjunit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GentlemanTest {
    @Test
    public void testGentleman(){
        //Given
        Gentleman gentleman = new Gentleman();

        //When
        String greeting = gentleman.sayHello("John Doe");

        //Then
        assertThat(greeting, equalTo("Hello John Doe!"));

        //When
        greeting = gentleman.sayHello(null);
        //Then
        assertThat(greeting, equalTo("Hello Anonymous!"));
    }
}
