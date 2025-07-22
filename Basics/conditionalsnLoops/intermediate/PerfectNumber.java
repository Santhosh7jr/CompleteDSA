import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter a number: ");
        int number=scanner.nextInt();

        scanner.close();

        int divisorSum=0;

        for(int i=1;i<number;i++){
            if(number%i==0){
                divisorSum+=i;
            }
        }
        System.out.println(number==divisorSum);
    }    
}
