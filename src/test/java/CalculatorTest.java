

import org.example.ArrayListStack;
import org.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = Calculator.getInstance();
        calculator.setStack(new ArrayListStack<>());
    }

    @Test
    public void testConvertToPostfix() {
        String infix = "3+4*2/(1-5)";
        String expected = "3 4 2 * 1 5 - / +";
        String actual = calculator.convertToPostfix(infix);
        assertEquals(expected, actual);
    }

    @Test
    public void testEvaluatePostfix() {
        String postfix = "3 4 2 * 1 5 - / +";
        double expected = 1.0;
        double actual = calculator.evaluatePostfix(postfix);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testExceptions() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.evaluatePostfix("10 0 /");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.convertToPostfix("3+4*2/(1-5)a");
        });
        assertThrows(IllegalStateException.class, () -> {
            Calculator uninitializedCalculator = new Calculator();
            uninitializedCalculator.convertToPostfix("3+4*2/(1-5)");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.convertToPostfix(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluatePostfix("");
        });
    }
}