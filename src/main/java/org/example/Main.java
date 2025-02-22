package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            // Display the menu
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            // Exit condition
            if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }

            // Validate choice
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice. Please select a valid option (1-5).");
                continue;
            }

            // Take input for two numbers
            System.out.print("Enter the first number: ");
            int num1;
            try {
                num1 = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            System.out.print("Enter the second number: ");
            int num2;
            try {
                num2 = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            // Perform the selected operation
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

        scanner.close();
    }
}

class Calculator {
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
}