import java.util.*;

public class Power {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the base: ");
        int base=scanner.nextInt();

        System.out.print("enter the exponent: ");
        int exponent=scanner.nextInt();
        int reference=exponent;

        scanner.close();

        int power=1;

        while (exponent!=0) {
            power*=base;
            exponent--;
        }

        System.out.format("%d to the power of %d is %d", base, reference, power);

    }
}
