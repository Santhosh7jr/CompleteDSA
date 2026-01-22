package DynamicProgramming.Knapsack.Variations.SubsetSum;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] arr = {2, 5, 7, 8};
        int sum = 11;
        int[] count = {0};
        List<Integer> list = new ArrayList<>();

        System.out.println((checkIfSubsetExistsUsingNumericalTabulation(arr, sum, list).isEmpty()) ? "No Subset Exists" : list);

        System.out.println(checkIfSubsetExistsUsingBooleanTabulation(arr, sum));

    }

    public static boolean checkIfSubsetExistsUsingRecursion(int[] arr, int sum, int idx, int sum2) {

        if (sum == sum2) return true;
        if (idx >= arr.length) return false;

        boolean include = false;
        if (sum2 + arr[idx] <= sum) include = checkIfSubsetExistsUsingRecursion(arr, sum, idx + 1, sum2 + arr[idx]);

        boolean notInclude = checkIfSubsetExistsUsingRecursion(arr, sum, idx + 1, sum2);

        return include || notInclude;

    }

    public static String getAllNumbersIfSubsetExistsUsingRecursion(int[] arr, int sum, int idx, int sum2, String str) {

        if (sum == sum2) return str;
        if (idx >= arr.length) return "";

        String include = "";
        if (sum2 + arr[idx] <= sum) include = getAllNumbersIfSubsetExistsUsingRecursion(arr, sum, idx + 1, sum2 + arr[idx], str + " " +arr[idx]);

        String notInclude = getAllNumbersIfSubsetExistsUsingRecursion(arr, sum, idx + 1, sum2, str);

        return (! include.isEmpty()) ? include : notInclude;

    }

    public static boolean checkIfSubsetExistsUsingMemoization(int[] arr, int sum, int idx, int sum2, boolean[][] dp) {

        if (sum == sum2) return true;
        if (dp[idx][sum2]) return true;
        if (idx >= arr.length) return false;

        boolean include = false;
        if (sum2 + arr[idx] <= sum) include = checkIfSubsetExistsUsingMemoization(arr, sum, idx + 1, sum2 + arr[idx], dp);

        boolean notInclude = checkIfSubsetExistsUsingMemoization(arr, sum, idx + 1, sum2, dp);

        return dp[idx][sum2] = include || notInclude;

    }

    public static boolean checkIfSubsetExistsUsingMemoization(int[] arr, int sum, int idx, int sum2, boolean[][] dp, int[] count) {

        if (sum == sum2) return true;

        if (dp[idx][sum2]) {
            count[0]++;
            return true;
        }

        if (idx >= arr.length) return false;

        boolean include = false;
        if (sum2 + arr[idx] <= sum) include = checkIfSubsetExistsUsingMemoization(arr, sum, idx + 1, sum2 + arr[idx], dp, count);

        boolean notInclude = checkIfSubsetExistsUsingMemoization(arr, sum, idx + 1, sum2, dp, count);

        return dp[idx][sum2] = include || notInclude;

    }

    public static boolean checkIfSubsetExistsUsingNumericalTabulation(int[] arr, int sum) {

        int[][] dp = new int[arr.length + 1][sum + 1];

        if (sum == 0) return true;

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

                System.out.print(dp[i][j] + "\t");
                if (dp[i][j] == sum) return true;

            }
            System.out.println();
        }

        return false;

    }

    public static List<Integer> checkIfSubsetExistsUsingNumericalTabulation(int[] arr, int sum, List<Integer> list) {

        int[][] dp = new int[arr.length + 1][sum + 1];

        if (sum == 0) return list;

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

                if (dp[i][j] == sum) return getAllNumbers(arr, sum, list, i, j, dp);

            }
        }

        return list;

    }

    private static List<Integer> getAllNumbers(int[] arr, int sum, List<Integer> list, int i, int j , int[][] dp) {

        while (sum > 0) {

            if (dp[i][j] != dp[i - 1][j]) {
                list.add(arr[i - 1]);
                sum -= arr[i - 1];
                j -= arr[i - 1];
            }

            i--;

        }

        return list;

    }

    public static boolean checkIfSubsetExistsUsingBooleanTabulation(int[] arr, int sum) {

        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i <= arr.length; i++) dp[i][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                /*if ((j - arr[i - 1]) >= 0 && (dp[i - 1][j - arr[i - 1]])) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

                if (j == sum && dp[i][j]) return true;*/

                if (arr[i - 1] <= j) {

                    dp[i][j] = (dp[i - 1][j - arr[i - 1]]) || (dp[i - 1][j]);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }

        }

        return dp[dp.length - 1][dp[0].length - 1];

    }

}
