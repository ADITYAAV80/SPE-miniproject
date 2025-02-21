package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("Enter two numbers (or type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length == 2) {
                try {
                    int num1 = Integer.parseInt(parts[0]);
                    int num2 = Integer.parseInt(parts[1]);
                    System.out.println(num1 + " + " + num2 + " = " + calculator.add(num1, num2));
                } catch (NumberFormatException e) {
                    System.out.println("Please enter valid numbers.");
                }
            } else {
                System.out.println("Invalid input. Enter two numbers separated by space.");
            }
        }

        scanner.close();
    }
}
