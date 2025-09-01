package calculatortest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitExample {
    @Test
    public void exampleTestMethod(){
        assertEquals(3,2+1);
    }

}
