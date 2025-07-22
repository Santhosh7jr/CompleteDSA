import java.util.Scanner;

public class SumOfInputs {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        int number;
        int sumOfNegatives=0;
        int sumOfOdds=0;
        int sumOfEvens=0;

        while (true) {
            System.out.print("Enter any number(0 for exit): ");
            number=scanner.nextInt();

            if(number==0){
                break;
            }

            if(number<0){
                sumOfNegatives+=number;
            }else if(number%2==0){
                sumOfEvens+=number;
            }else{
                sumOfOdds+=number;
            }
        }

        System.out.println("\nsum of negatives: "+sumOfNegatives);
        System.out.println("\nsum of evens: "+sumOfEvens);
        System.out.println("\nsum of odds: "+sumOfOdds);

        scanner.close();
    }
}
