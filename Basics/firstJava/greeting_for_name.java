import java.util.*;

public class greeting_for_name {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name=scanner.nextLine();

        scanner.close();

        System.out.println("Hello "+name);
    }
}
