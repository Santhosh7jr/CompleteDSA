import java.util.*;

public class simpleInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter principal: ");
        double principal = scanner.nextDouble();

        System.out.print("enter time (in years):");
        int time = scanner.nextInt();

        System.out.print("enter rate: ");
        double rate = scanner.nextDouble();

        double SI=(principal*time*rate)/100;

        System.out.println("the simple interest is: "+SI);

        scanner.close();
    }
}
