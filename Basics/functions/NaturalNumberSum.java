import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);
        
        System.out.print("enter the number: ");
        int number=scanner.nextInt();

        scanner.close();

        System.out.println("the sum of n natural numbers is --> "+findSum(number));
    }

    public static int findSum(int number){

        int sum=0;
        for(int i=1;i<=number;i++){
            sum+=i;
        }
        return sum;
    }
}
