package org.example;

public class Calculator {

    /* adding commment to test if everything is running well */
    /* comment 2 to test pipeline */
    /* comment 3*/
    /* comment 4 */

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot compute square root of a negative number.");
        }
        return Math.sqrt(x);
    }

    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double ln(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Natural logarithm is not defined for non-positive numbers.");
        }
        return Math.log(x);
    }

    public double power(double base, double exponent) {
        if (base == 0 && exponent < 0) {
            throw new IllegalArgumentException("Undefined: 0 cannot be raised to a negative power.");
        }
        return Math.pow(base, exponent);
    }

}
