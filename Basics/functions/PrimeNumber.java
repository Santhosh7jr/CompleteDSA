import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the number: ");
        int number= scanner.nextInt();
        scanner.close();

        System.out.println(isPrime(number));
    }

    public static boolean isPrime(int number){

        for(int i=3;i<number;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
