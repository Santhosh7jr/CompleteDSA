import java.util.*;

public class leetcode1281 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter any number: ");
        int n = scanner.nextInt();
        scanner.close();

        System.out.println(getResult(n));
    }

    public static int getResult(int n) {
        int sum=0;
        int product=1;

        while(n!=0){
            sum+=n%10;
            product*=n%10;
            n/=10;
        }
        return product-sum;
    }

}
