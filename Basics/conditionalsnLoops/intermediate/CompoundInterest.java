import java.util.*;

public class CompoundInterest {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the initial investment: ");
        double initialInvestment=scanner.nextDouble();

        System.out.print("enter interest rate percentage: ");
        double interest=scanner.nextDouble();

        System.out.print("enter number of times interest is compounded per year: ");
        int compounded=scanner.nextInt();

        System.out.print("enter time in years: ");
        int time=scanner.nextInt();

        scanner.close();

        System.out.format("the compounded interest is: %.2f",(initialInvestment*Math.pow(1+((interest/100)/compounded),compounded*time)));
    }
}
