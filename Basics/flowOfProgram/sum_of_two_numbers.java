import java.util.*;

public class sum_of_two_numbers {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter first number: ");
        int number1=scanner.nextInt();

        System.out.println("Enter second number: ");
        int number2=scanner.nextInt();

        int sum=number1+number2;

        System.out.format("The sum of %d and %d is: %d",number1,number2,sum);

        scanner.close();
    }
}
