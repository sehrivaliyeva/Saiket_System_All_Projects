package all_projects.Calculator_Application;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            System.out.println("=== Calculator Menu ===");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Percentage Calculation");
            System.out.println("6. Modulus (Remainder)");
            System.out.println("7. Exit");
            System.out.print("Choose an option (1-7): ");

            int choice = scanner.nextInt();

            if (choice == 7) {
                exit = true;
                System.out.println("Exiting... Thank you for using the calculator!");
                break;
            }

            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Result: " + add(num1, num2));
                        break;
                    case 2:
                        System.out.println("Result: " + subtract(num1, num2));
                        break;
                    case 3:
                        System.out.println("Result: " + multiply(num1, num2));
                        break;
                    case 4:
                        System.out.println("Result: " + divide(num1, num2));
                        break;
                    case 5:
                        System.out.println("Result: " + percentage(num1, num2));
                        break;
                    case 6:
                        System.out.println("Result: " + modulus(num1, num2));
                        break;
                    default:
                        System.out.println("Invalid option! Please select a valid option.");
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }


    public static double add(double a, double b) {
        return a + b;
    }


    public static double subtract(double a, double b) {
        return a - b;
    }


    public static double multiply(double a, double b) {
        return a * b;
    }


    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }

    public static double percentage(double total, double percent) {
        return (total * percent) / 100;
    }

    public static double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot find modulus with zero.");
        }
        return a % b;
    }
}





