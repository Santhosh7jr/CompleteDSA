import java.util.*;

public class PalindromNumber {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the number: ");
        int num = scanner.nextInt();

        scanner.close();

        int reversed = 0;
        int original = num;

        while (num != 0) {
            int digit = num % 10;  
            reversed = reversed * 10 + digit; 
            num /= 10;     
        }

        System.out.println(reversed==original);
    }
}
