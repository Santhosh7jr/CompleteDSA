import java.util.Scanner;

public class largestInputNumber {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);
        int result=Integer.MIN_VALUE;
        System.out.print("enter any number: ");
        int number=scanner.nextInt();

       while (number!=0) {

            if(number>result){
                result=number;
            }

            System.out.print("enter any number: ");
            number=scanner.nextInt();
       }
       scanner.close();

       System.out.println("\nthe largest among all the inputs is: "+result);

    }
}
