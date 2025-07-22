import java.util.*;

public class StringReverse {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter a string: ");
        String str = scanner.nextLine();

        scanner.close();

        int length=str.length();
        String reversedString="";

        for(int i=length-1;i>=0;i--){
            reversedString+=str.charAt(i);
        }

        System.out.println("\nthe reversed format of the string: "+reversedString);
    }
}
