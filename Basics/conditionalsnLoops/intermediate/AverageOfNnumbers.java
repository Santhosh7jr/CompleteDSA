import java.util.*;

public class AverageOfNnumbers {
    public static void main(String[] args) {
        
        int count=0;
        int sum=0;

        Scanner scanner=new Scanner(System.in);
        int number;

        do{
            System.out.print("Enter any number(0 for exit): ");
            number=scanner.nextInt();

            sum+=number;
            count++;
        }while(number!=0);

        System.out.println("the average of "+count+" numbers is: "+sum/count);

        scanner.close();
    }
}
