package calculatortest;

import org.example.calculator.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator;

    @BeforeAll
    static void beforeExecute() {
        System.out.println("Welcome ");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Further test case is testing");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Passed test case ");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All test cases completed");
    }

    CalculatorTest() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        int value = calculator.add(2, 9);
        assertEquals(11, value);
    }

    @Test
    public void testSubtract() {
        int value = calculator.subtract(9, 7);
        assertEquals(2, value);
    }

    @Test
    public void testMultiply() {
        int value = calculator.multiply(2, 3);
        assertEquals(6, value);
    }

    @Test
    public void testDevide() {
        int value = calculator.divide(4, 2);
        assertEquals(2, value);
    }

    @Test
    public void testModules() {
        int value = calculator.modules(2, 9);
        assertEquals(1, value);
    }

}
