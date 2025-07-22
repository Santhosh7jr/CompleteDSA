import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number=scanner.nextInt();

        scanner.close();

        if(isEven(number)){
            System.out.println("\nthe number is even");
        }else{
            System.out.println("\nthe number is odd");
        }
    }

    public static boolean isEven(int n){
        if(n%2==0){
            return true;
        }
        return false;
    }
}
