import java.util.*;

public class SumOfNnumbers {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        int number;
        int sum=0;

        do{
            System.out.print("Enter any number(0 for exit): ");
            number=scanner.nextInt();

            sum+=number;
        }while(number!=0);

        System.out.format("\nthe sum is: %d",sum);

        scanner.close();
    }
}
