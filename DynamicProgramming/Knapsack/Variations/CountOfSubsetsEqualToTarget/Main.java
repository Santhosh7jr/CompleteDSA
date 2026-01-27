package DynamicProgramming.Knapsack.Variations.CountOfSubsetsEqualToTarget;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(countOfSubsetsUsingRecursion(new int[] {2, 3, 5, 6, 8, 10}, 10, 0));
        System.out.println(countOfSubsetsUsingMemoization(new int[] {2, 3, 5, 6, 8, 10}, 10, 0, new int[7][11]));
        System.out.println(countOfSubsetsUsingTabulation(new int[] {2, 3, 5, 6, 8, 10}, 10));

    }

    public static int countOfSubsetsUsingRecursion(int[] arr, int target, int idx) {

        if (target == 0) return 1;

        if (idx == arr.length) return 0;

        int include = 0;

        if (target - arr[idx] >= 0) include = countOfSubsetsUsingRecursion(arr, target - arr[idx], idx + 1);

        int notInclude = countOfSubsetsUsingRecursion(arr, target, idx + 1);

        return include + notInclude;

    }

    public static int countOfSubsetsUsingMemoization(int[] arr, int target, int idx, int[][] dp) {

        if (dp[idx][target] != 0) return dp[idx][target];

        if (target == 0) return 1;

        if (idx == arr.length) return 0;

        int include = 0;

        if (target - arr[idx] >= 0) include = countOfSubsetsUsingMemoization(arr, target - arr[idx], idx + 1, dp);

        int notInclude = countOfSubsetsUsingMemoization(arr, target, idx + 1, dp);

        return dp[idx][target] = include + notInclude;

    }

    public static int countOfSubsetsUsingTabulation(int[] arr, int target) {

        int[][] dp = new int[arr.length + 1][target + 1];

        for (int i = 0; i <= arr.length; i++) dp[i][0] = 1;

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= target; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }

        }

        return dp[arr.length][target];

    }

}
