package DynamicProgramming.UnboundedKnapsack.Variations.CoinChange_II;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 10};
        int target = 100;

        int[][] dp = new int[arr.length + 1][target + 1];

        for (int i = 0; i <= arr.length; i++) Arrays.fill(dp[i], -1);

        System.out.println(minCountOfCoinsUsingRecursion(arr, target, 0, 0, 0));
        System.out.println(minCountOfCoinsUsingMemoization(arr, target, 0, 0, dp));
        System.out.println(minCountOfCoinsUsingTabulation(arr, target));

    }

    public static int minCountOfCoinsUsingRecursion(int[] coins, int sum, int idx, int sumSoFar, int count) {

        if (idx >= coins.length) return Integer.MAX_VALUE;

        if (sumSoFar > sum) return Integer.MAX_VALUE;

        if (sum == sumSoFar) {
            return count;
        }

        int count1 = minCountOfCoinsUsingRecursion(coins, sum, idx, sumSoFar + coins[idx], count + 1);

        int count2 = minCountOfCoinsUsingRecursion(coins, sum, idx + 1, sumSoFar, count);

        return Math.min(count1, count2);

    }

    public static int minCountOfCoinsUsingMemoization(int[] coins, int sum, int idx, int sumSoFar, int[][] dp) {

        if (idx >= coins.length) return Integer.MAX_VALUE;

        if (sum == sumSoFar) {
            return 0;
        }

        if (sumSoFar > sum) return Integer.MAX_VALUE;

        if (dp[idx][sumSoFar] != -1) return dp[idx][sumSoFar];

        int count1 = minCountOfCoinsUsingMemoization(coins, sum, idx, sumSoFar + coins[idx], dp);

        if (count1 != Integer.MAX_VALUE) count1 = count1 + 1;

        int count2 = minCountOfCoinsUsingMemoization(coins, sum, idx + 1, sumSoFar, dp);

        return dp[idx][sumSoFar] = Math.min(count1, count2);

    }

    public static int minCountOfCoinsUsingTabulation(int[] arr, int target) {

        int[][] dp = new int[arr.length + 1][target + 1];

        for (int i = 0; i <= target; i++) dp[0][i] = Integer.MAX_VALUE - 1;

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= target; j++) {

                if (arr[i - 1] <= j) {

                    dp[i][j] = Math.min((1 + dp[i][j - arr[i - 1]]), dp[i - 1][j]);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[arr.length][target];

    }

}
