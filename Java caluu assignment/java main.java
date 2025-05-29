package lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicCalculator calculator = new BasicCalculator();
        
        System.out.println("Welcome to the Basic Calculator!");
        
        boolean continueCalculations = true;
        
        while (continueCalculations) {
            // Display menu
            System.out.println("\nChoose an operation:");
            System.out.println("1: Addition");
            System.out.println("2: Subtraction");
            System.out.println("3: Multiplication");
            System.out.println("4: Division");
            System.out.println("5: Exit");
            System.out.print("Select (1-5): ");
            
            try {
                int choice = scanner.nextInt();
                
                if (choice == 5) {
                    continueCalculations = false;
                    break;
                }
                
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid choice. Please select a number between 1 and 5.");
                    scanner.nextLine(); // Clear the buffer
                    continue;
                }
                
                // Get numbers from user
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();
                
                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();
                
                double result = 0;
                String operation = "";
                
                // Perform the selected operation
                switch (choice) {
                    case 1:
                        result = calculator.add(num1, num2);
                        operation = "Addition";
                        break;
                    case 2:
                        result = calculator.subtract(num1, num2);
                        operation = "Subtraction";
                        break;
                    case 3:
                        result = calculator.multiply(num1, num2);
                        operation = "Multiplication";
                        break;
                    case 4:
                        try {
                            result = calculator.divide(num1, num2);
                            operation = "Division";
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                            continue; // Skip to next iteration
                        }
                        break;
                }
                
                // Display the result
                System.out.printf("%s Result: %.2f%n", operation + ":", result);
                
                // Ask if user wants to continue
                System.out.print("Do another calculation? (yes/no): ");
                String continueChoice = scanner.next().toLowerCase();
                
                if (!continueChoice.equals("yes")) {
                    continueCalculations = false;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter numeric values only.");
                scanner.nextLine(); // Clear the invalid input from scanner
            }
        }
        
        System.out.println("Thank you for using the Basic Calculator!");
        scanner.close();
    }
}