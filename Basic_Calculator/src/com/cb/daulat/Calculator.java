package com.cb.daulat;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CalculatorService cal=new CalculatorService();
        boolean keepRunning = true;

        System.out.println("=======================Basic Calculator=================================================");

        while (keepRunning) {
            try {
                System.out.println("\nChoose an operation:");
                System.out.println("1. Addition (+)");
                System.out.println("2. Subtraction (-)");
                System.out.println("3. Multiplication (*)");
                System.out.println("4. Division (/)");
                System.out.println("5. Exit");

                System.out.print("Enter your choice (1-5): ");
                int choice = scanner.nextInt();
                
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid choice. Please select between 1 to 5.");
                    continue; // skip to the next iteration
                }

                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                double result = 0;

                switch (choice) {
                    case 1:
                        result = cal.add(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 2:
                        result = cal.subtract(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 3:
                        result = cal.multiply(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 4:
                        result = cal.divide(num1, num2); // might throw ArithmeticException
                        System.out.println("Result: " + result);
                        break;
                    case 5:
                    	keepRunning = false;
                        System.out.println("Calculator Exited. Thanks for Use!");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter valid numbers.");
                scanner.nextLine(); // clear buffer
            } catch (ArithmeticException e) {
                System.out.println("Math error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
