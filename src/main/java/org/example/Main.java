package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            displayMenu();
            int choice = getChoice(scanner);

            if (choice == 8) { // Exit option
                System.out.println("Goodbye!");
                break;
            }

            if (choice < 1 || choice > 7) {
                System.out.println("Invalid choice. Please select a valid option (1-8).");
                continue;
            }

            if (choice == 5) { // Square root option
                double num = getNumberInput(scanner, "Enter a number: ");
                performSquareRoot(calculator, num);
            } else if (choice == 6) { // Factorial option
                int num = getNumberInput(scanner, "Enter a number: ");
                performFactorial(calculator, num);
            } else if (choice == 7) { // Natural logarithm option
                double num = getNumberInput(scanner, "Enter a number: ");
                performNaturalLogarithm(calculator, num);
            } else {
                int num1 = getNumberInput(scanner, "Enter the first number: ");
                int num2 = getNumberInput(scanner, "Enter the second number: ");
                performOperation(calculator, choice, num1, num2);
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nChoose an operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Square Root");
        System.out.println("6. Factorial");
        System.out.println("7. Natural Logarithm (ln)");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice. Please enter a number.");
            return -1;
        }
    }

    private static int getNumberInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static void performOperation(Calculator calculator, int choice, int num1, int num2) {
        switch (choice) {
            case 1:
                System.out.println(num1 + " + " + num2 + " = " + calculator.add(num1, num2));
                break;
            case 2:
                System.out.println(num1 + " - " + num2 + " = " + calculator.subtract(num1, num2));
                break;
            case 3:
                System.out.println(num1 + " * " + num2 + " = " + calculator.multiply(num1, num2));
                break;
            case 4:
                try {
                    System.out.println(num1 + " / " + num2 + " = " + calculator.divide(num1, num2));
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid operation.");
                break;
        }
    }

    private static void performSquareRoot(Calculator calculator, double num) {
        try {
            System.out.println("√" + num + " = " + calculator.sqrt(num));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performFactorial(Calculator calculator, int num) {
        try {
            System.out.println(num + "! = " + calculator.factorial(num));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void performNaturalLogarithm(Calculator calculator, double num) {
        try {
            System.out.println("ln(" + num + ") = " + calculator.ln(num));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}