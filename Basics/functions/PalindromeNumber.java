import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the number: ");
        int number=scanner.nextInt();
        scanner.close();

        System.out.println(palindrome(number));
    }

    public static boolean palindrome(int number){
        int temp=number;

        int result=0;

        while (temp!=0) {
            result=(result*10)+(temp%10);
            temp/=10;
        }
        return result==number;
    }
}
