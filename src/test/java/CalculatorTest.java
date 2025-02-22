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

    @Test
    public void testSqrt() {
        Calculator calculator = new Calculator();
        assertEquals(2.0, calculator.sqrt(4.0), 0.0001); // √4 = 2
        assertEquals(3.0, calculator.sqrt(9.0), 0.0001); // √9 = 3
        assertEquals(0.0, calculator.sqrt(0.0), 0.0001); // √0 = 0
    }

    @Test
    public void testSqrtNegativeNumber() {
        Calculator calculator = new Calculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.sqrt(-1.0); // Square root of a negative number
        });
        assertEquals("Cannot compute square root of a negative number.", exception.getMessage());
    }

    @Test
    public void testFactorial() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.factorial(0)); // 0! = 1
        assertEquals(1, calculator.factorial(1)); // 1! = 1
        assertEquals(2, calculator.factorial(2)); // 2! = 2
        assertEquals(6, calculator.factorial(3)); // 3! = 6
        assertEquals(120, calculator.factorial(5)); // 5! = 120
    }

    @Test
    public void testFactorialNegativeNumber() {
        Calculator calculator = new Calculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(-1); // Factorial of a negative number
        });
        assertEquals("Factorial is not defined for negative numbers.", exception.getMessage());
    }

    @Test
    public void testLn() {
        Calculator calculator = new Calculator();
        assertEquals(0.0, calculator.ln(1.0), 0.0001); // ln(1) = 0
        assertEquals(1.6094, calculator.ln(5.0), 0.0001); // ln(5) ≈ 1.6094
        assertEquals(2.3026, calculator.ln(10.0), 0.0001); // ln(10) ≈ 2.3026
    }

    @Test
    public void testLnNonPositiveNumber() {
        Calculator calculator = new Calculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.ln(0.0); // Natural logarithm of 0
        });
        assertEquals("Natural logarithm is not defined for non-positive numbers.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.ln(-1.0); // Natural logarithm of a negative number
        });
        assertEquals("Natural logarithm is not defined for non-positive numbers.", exception.getMessage());
    }
}