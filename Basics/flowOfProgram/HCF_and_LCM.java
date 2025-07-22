import java.util.*;

public class HCF_and_LCM {

    static int hcf(int n1,int n2){
        if(n2==0){
            return n1;
        }
        return hcf(n2, n1%n2);
    }

    static int lcm(int n1,int n2){
        return n1*n2/hcf(n1, n2);
    }

    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.println("enter numbers to find out gcd and lcm");
        System.out.print("Enter first number: ");
        int number1=scanner.nextInt();

        System.out.print("Enter second number: ");
        int number2=scanner.nextInt();

        scanner.close();

        System.out.format("\nthe HCF of %d abd %d is: %d\n",number1,number2,hcf(number1, number2));

        System.out.format("the LCM of %d and %d is: %d",number1,number2,lcm(number1, number2));
    } 
}
