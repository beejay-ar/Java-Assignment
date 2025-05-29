package lab1;

public class BasicCalculator {
    
    // Addition method
    public double add(double num1, double num2) {
        return num1 + num2;
    }
    
    // Subtraction method
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }
    
    // Multiplication method
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }
    
    // Division method with error handling
    public double divide(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed.");
        }
        return num1 / num2;
    }
}