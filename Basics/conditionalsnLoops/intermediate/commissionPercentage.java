import java.util.Scanner;

public class commissionPercentage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Total Sales: ");
        double totalSales = sc.nextDouble();

        System.out.print("Enter Commission Amount: ");
        double commissionAmount = sc.nextDouble();

        if(commissionAmount>totalSales){
            System.out.println("wrong input");
        }else{
            double commissionPercentage = (commissionAmount / totalSales) * 100;
    
            System.out.printf("Commission Percentage is: %.2f%%", commissionPercentage);
        }
        sc.close();
    }
}
