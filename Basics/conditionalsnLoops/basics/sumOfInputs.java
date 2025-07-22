import java.util.*;

public class sumOfInputs {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);
        int sum=0;
        System.out.print("enter any number: ");
        int number=scanner.nextInt();

       while (number!=0) {
            sum+=number;
            System.out.print("enter any number: ");
            number=scanner.nextInt();
       }
       scanner.close();

       System.out.println("\nthe sum of all inputs is: "+sum);

    }
}
