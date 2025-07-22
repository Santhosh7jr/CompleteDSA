import java.util.*;

public class AdditionOfTwoNumbers {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the first number: ");
        int num1=scanner.nextInt();

        System.out.print("enter the second number: ");
        int num2=scanner.nextInt();

        scanner.close();

        System.out.format("the sum of %d and %d is: %d",num1,num2,getSum(num1,num2));
    }

    public static int getSum(int n1,int n2){
        return n1+n2;
    }
}
