import java.util.*;

public class even_or_odd {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter the number to check whether it is even or odd: ");
        int number=scanner.nextInt();

        if((number&1)!=0){
            System.out.println("number is odd");
        }else{
            System.out.println("number is even");
        }
        scanner.close();
    }
}
