import java.util.*;;

public class largestOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        scanner.close();

        if(num1>num2){
            System.out.println("num1 is greater than num2");
        }else{
            System.out.println("num2 is greater than num1");
        }
    }
}
