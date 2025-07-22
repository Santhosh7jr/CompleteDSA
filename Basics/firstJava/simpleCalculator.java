import java.util.*;

public class simpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        scanner.close();

        switch (operator) {
            case '+':
                System.out.format("The sum of %.2f and %.2f is %.2f%n", num1, num2, num1 + num2);
                break;
            case '-':
                System.out.format("The difference of %.2f and %.2f is %.2f%n", num1, num2, num1 - num2);
                break;
            case '*':
                System.out.format("The product of %.2f and %.2f is %.2f%n", num1, num2, num1 * num2);
                break;
            case '/':
                if (num2 != 0) {
                    System.out.format("The quotient of %.2f and %.2f is %.2f%n", num1, num2, num1 / num2);
                } else {
                    System.out.println("Error! Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Error! Invalid operator.");
                break;
        }
    }
}