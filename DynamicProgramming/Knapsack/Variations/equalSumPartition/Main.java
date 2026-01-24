package DynamicProgramming.Knapsack.Variations.equalSumPartition;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] arr = {5, 10, 5};
        int sum = 0;

        for (int num : arr) sum += num;

        boolean[][] dp = new boolean[arr.length + 1][sum / 2 + 1];

//        System.out.println(sum % 2 == 0 && checkIfExistsUsingMemoization(arr, sum / 2, 0, dp));
//        System.out.println(sum % 2 == 0 && checkIfExistsUsingRecursion(arr, sum / 2, 0));
        System.out.println(sum % 2 == 0 && checkIfExistsUsingTabulation(arr, sum / 2, dp));

    }

    public static boolean checkIfExistsUsingRecursion(int[] arr, int sum, int idx) {

        if (sum == 0) return true;

        if (sum < 0) return false;

        if (idx == arr.length) return false;

        boolean include = checkIfExistsUsingRecursion(arr, sum - arr[idx], idx + 1);
        boolean notInclude = checkIfExistsUsingRecursion(arr, sum, idx + 1);

        return include || notInclude;

    }

    public static boolean checkIfExistsUsingMemoization(int[] arr, int sum, int idx, boolean[][] dp) {

        if (sum < 0) return false;
        if (sum == 0) return true;
        if (idx == arr.length) return false;

        if (dp[idx][sum]) return dp[sum][idx];

        boolean include = checkIfExistsUsingMemoization(arr, sum - arr[idx], idx + 1, dp);
        boolean notInclude = checkIfExistsUsingMemoization(arr, sum, idx + 1, dp);

        return dp[idx][sum] = include || notInclude;

    }

    public static boolean checkIfExistsUsingTabulation(int[] arr, int target, boolean[][] dp) {

        for (int i = 0; i <= arr.length; i++) dp[i][0] = true;

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= target; j++) {

                if (arr[i - 1] <= j) {

                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];

                } else {

                    dp[i][j] = dp[i- 1][j];

                }

                if (j == target && dp[i][j]) return true;

            }
        }

        return dp[arr.length][target];

    }

    public static boolean isPossibleUsingTabulation(int[] arr) {

        int sum = 0;

        for (int num : arr) sum += num;

        if (sum % 2 == 1) return false;

        return DynamicProgramming.Knapsack.Variations.SubsetSum.Main.checkIfSubsetExistsUsingBooleanTabulation(arr, sum / 2);

    }

}
