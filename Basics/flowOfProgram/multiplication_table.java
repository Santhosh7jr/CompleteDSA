import java.util.*;

public class multiplication_table {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter the number that you want to print multiplication table of: ");
        int number=scanner.nextInt();
        scanner.close();

        for(int i=1;i<=10;i++){
            System.out.format("\n %d X %d = %d",number,i,number*i);
        }
    }
}
