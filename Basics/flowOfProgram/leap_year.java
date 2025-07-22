import java.util.*;

/**
 * leap_year
 */
public class leap_year {

    public static void main(String[] args) {
        System.out.print("Enter the year: ");
        Scanner scanner = new Scanner(System.in);
        int year=scanner.nextInt();
        scanner.close();

        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            System.out.println("leap year");
        }else{
            System.out.println("not leap year");
        }
    }
}