import java.util.Scanner;

public class FindFactorial {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the number: ");
        int number=scanner.nextInt();

        scanner.close();

        System.out.format("the factorial of %d is --> %d",number,factorial(number));
    }

    public static int factorial(int number){

        int fact=1;

        for(int i=1;i<=number;i++){
            fact*=i;
        }
        return fact;
    }
}
