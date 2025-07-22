import java.util.*;

public class ArmstrongNumber {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the number: ");
        int number=scanner.nextInt();
        scanner.close();

        int temp=number;
        int Armstrong=0;

        while (number!=0) {
            Armstrong+=(number%10)*(number%10)*(number%10);
            number/=10;
        }
        System.out.println(temp==Armstrong);
    }
}
