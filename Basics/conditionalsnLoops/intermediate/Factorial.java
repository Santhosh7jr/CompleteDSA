import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.print("enter the number: ");
        int number=scanner.nextInt();
        scanner.close();

        int fact=1;
        for(int i=number;i>1;i--){
            fact*=i;
        }
        System.out.println("Factorial of "+number+" is: "+fact);
    }
}

