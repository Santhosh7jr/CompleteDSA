import java.util.Scanner;

public class FutureInvestmentValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the investment amount: ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (in %): ");
        double annualInterestRate = scanner.nextDouble() / 100;

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        double futureValue = presentValue * Math.pow(1 + annualInterestRate, years);

        System.out.printf("Future Investment Value: %.2f\n", futureValue);

        scanner.close();
    }    
}
