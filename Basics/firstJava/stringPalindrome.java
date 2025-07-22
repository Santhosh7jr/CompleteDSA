import java.util.*;

public class stringPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = scanner.nextLine();
        scanner.close();

        if(isPalindrome(str,0,str.length()-1)){
            System.out.println("yes,the string is palindrome");
        }else{
            System.out.println("no,the string is not palindrome");
        }
    }
    public static boolean isPalindrome(String str,int start,int end) {
        if(start>end){
            return true;
        }
        if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
        return isPalindrome(str, start+1, end-1);
    }
}
