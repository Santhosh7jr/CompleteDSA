package DynamicProgramming.Fibonacci;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(fibonacciWithOptimization(7));

    }

    //finding fibonacci number using simple recursion
    public static int fibonacci(int n){
        if(n<=1) return n;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    //finding fibonacci number using DP - Memoization
    public static int fibonacci(int n,int dp[]){

        if(n<=1) return dp[n]=n;

        return dp[n]=fibonacci(n-1,dp)+fibonacci(n-2,dp);

    }

    //finding fibonacci number using DP - Tabulation
    public static int fibonacciWithTabulation(int n,int[] dp){
        dp[0]=0;
        dp[1]=1;

        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];

    }

    //finding fibonacci number with space optimization
    public static int fibonacciWithOptimization(int n){

        int first=0;
        int second=1;

        for (int i=2;i<=n;i++){

            int temp=first+second;
            first=second;
            second=temp;

        }

        return second;

    }

}
