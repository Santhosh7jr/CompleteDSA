package DynamicProgramming.ClimbingStairs;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(climbStairs2(5));

    }

    //recursive solution
    public static int climb(int n){

        if(n<=2) return n;

        return climb(n-1)+climb(n-2);

    }

    //DP - memoization
    public static int climb(int n,int[] dp){

        if(n<=2) return dp[n]=n;

        return dp[n]=climb(n-1,dp)+climb(n-2,dp);

    }

    //DP - tabulation
    public static int climbStairs(int n){

        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;

        for (int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];

    }

    //DP - space optimization
    public static int climbStairs2(int n){

        int first=1;
        int second=2;

        for (int i=3;i<=n;i++){
            int temp=first+second;
            first=second;
            second=temp;
        }

        return second;

    }

}
