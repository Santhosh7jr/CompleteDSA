import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the number: ");
        int number=scanner.nextInt();

        scanner.close();

        int sum=0;

        while (number!=0) {
            sum+=number%10;
            number/=10;
        }

        System.out.println("the sum of digits is: "+sum);
    }
}
