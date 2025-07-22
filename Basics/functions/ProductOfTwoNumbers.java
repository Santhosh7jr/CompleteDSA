import java.util.Scanner;

public class ProductOfTwoNumbers {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the first number: ");
        int num1=scanner.nextInt();

        System.out.print("enter the second number: ");
        int num2=scanner.nextInt();

        scanner.close();

        System.out.format("\nthe product of %d and %d is: %d",num1,num2,getProduct(num1,num2));
    }

    public static int getProduct(int n1,int n2){
        return n1*n2;
    }
}
