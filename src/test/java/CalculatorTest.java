import org.example.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3)); // 2 + 3 = 5
        assertEquals(-1, calculator.add(-4, 3)); // -4 + 3 = -1
        assertEquals(0, calculator.add(0, 0)); // 0 + 0 = 0
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(3, 2)); // 3 - 2 = 1
        assertEquals(-5, calculator.subtract(2, 7)); // 2 - 7 = -5
        assertEquals(0, calculator.subtract(0, 0)); // 0 - 0 = 0
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.multiply(2, 3)); // 2 * 3 = 6
        assertEquals(-8, calculator.multiply(2, -4)); // 2 * -4 = -8
        assertEquals(0, calculator.multiply(0, 5)); // 0 * 5 = 0
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(6, 3)); // 6 / 3 = 2
        assertEquals(-2, calculator.divide(-6, 3)); // -6 / 3 = -2
        assertEquals(0, calculator.divide(0, 5)); // 0 / 5 = 0
    }

    @Test
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0); // Division by zero
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}