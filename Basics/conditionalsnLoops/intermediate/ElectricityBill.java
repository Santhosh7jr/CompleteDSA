import java.util.*;

public class ElectricityBill {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the number of units consumed: ");
        int units=scanner.nextInt();
        scanner.close();

        int ratePerUnit=5;
        int fixedCharge=100;
        double taxes=0.05;

        double electricityBill=(units*ratePerUnit)+fixedCharge+(taxes*units*ratePerUnit);

        System.out.println("the electricity bill cost is: "+electricityBill+" RS");
    }
}
