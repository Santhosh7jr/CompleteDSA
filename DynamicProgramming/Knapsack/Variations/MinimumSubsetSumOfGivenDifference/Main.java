package DynamicProgramming.Knapsack.Variations.MinimumSubsetSumOfGivenDifference;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 3};
        int target = 1;
        int sum = 0;

        for (int i : arr) sum += i;

        if ((sum + target) % 2 == 1) {
            System.out.println("there are no such subsets exists!");
        } else {

            int requiredSubsetSum = sum - ((sum + target) / 2);

            int[][] dp = new int[arr.length + 1][requiredSubsetSum + 1];

            for (int[] row : dp) Arrays.fill(row, -1);

            System.out.println(getCountUsingRecursion(arr, requiredSubsetSum, 0));
            System.out.println(getCountUsingMemoization(arr, requiredSubsetSum, 0, dp));
            System.out.println(getCountUsingTabulation(arr, requiredSubsetSum));

        }

    }

    public static int getCountUsingRecursion(int[] arr, int target, int idx) {

        if (target == 0) return 1;
        if (target < 0) return 0;
        if (idx == arr.length) return 0;

        int include = getCountUsingRecursion(arr, target - arr[idx], idx + 1);
        int notInclude = getCountUsingRecursion(arr, target, idx + 1);

        return include + notInclude;

    }

    public static int getCountUsingMemoization(int[] arr, int target, int idx, int[][] dp) {

        if (target < 0) return 0;

        if (dp[idx][target] != -1) return dp[idx][target];

        if (target == 0) return 1;

        if (idx == arr.length) return 0;

        int include = getCountUsingMemoization(arr, target - arr[idx], idx + 1, dp);
        int notInclude = getCountUsingMemoization(arr, target, idx + 1, dp);

        return dp[idx][target] = include + notInclude;

    }

    public static int getCountUsingTabulation(int[] arr, int target) {

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
