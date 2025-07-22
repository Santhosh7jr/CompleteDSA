import java.util.*;

public class fibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the number: ");
        int n = scanner.nextInt();

        scanner.close();

        System.out.println("the fibonacci series upto "+n+" terms is:"+Arrays.toString(fSeries(n)));
    }
    public static int[] fSeries(int n) {
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;

        for(int i=2;i<n;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib;
    }
}
