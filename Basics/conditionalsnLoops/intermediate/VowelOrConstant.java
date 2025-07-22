import java.util.*;

public class VowelOrConstant {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the character: ");
        char character=scanner.next().charAt(0);

        scanner.close();

        if(character=='a' || character=='e' || character=='i' || character=='o' || character=='u'){
            System.out.println("\ntrue");
        }else{
            System.out.println("\nfalse");
        }
    }
}
