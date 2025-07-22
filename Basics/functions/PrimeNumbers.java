import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the starting point: ");
        int starting=scanner.nextInt();

        System.out.print("enter the ending point: ");
        int ending=scanner.nextInt();

        scanner.close();

        allPrimes(starting,ending);
    }

    public static void allPrimes(int starting,int ending){

        System.out.format("\nprime numbers from %d to %d are --> [ ",starting,ending);

        for(int i=starting;i<ending;i++){
            if(isPrime(i)){
                System.out.print(i+" , ");
            }
        }
        System.out.println("END ]");
    }

    public static boolean isPrime(int number){

        for(int i=2;i<number;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

}
