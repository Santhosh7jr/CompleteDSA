package DynamicProgramming.Knapsack.Variations.MinimumSubsetSumDifference;

public class Main {

    public static void main(String[] args) {

        int[] arr = {1, 5, 6, 11};
        int sum = 0;

        for (int j : arr) sum += j;

        int half = sum / 2;
        int[][] dp = new int[arr.length + 1][half + 1];

//        int nearestToHalf = findNearestSubsetSumUsingRecursion(arr, half, 0, 0);
//        int nearestToHalf = findNearestSubsetSumUsingMemoization(arr, half, 0, 0, dp);

        int nearestToHalf = findNearestSubsetSumUsingTabulation(arr, half, dp);

        System.out.println("The Minimum Subset Sum Difference is: " + Math.abs((sum - nearestToHalf) - nearestToHalf));

    }

    public static int findNearestSubsetSumUsingRecursion(int[] arr, int target, int idx, int sum) {

        if (idx == arr.length) return sum;
        if (arr[idx] + sum > target) return sum;

        int include = findNearestSubsetSumUsingRecursion(arr, target, idx + 1, sum + arr[idx]);
        int notInclude = findNearestSubsetSumUsingRecursion(arr, target, idx + 1, sum);

        return Math.max(include, notInclude);

    }

    public static int findNearestSubsetSumUsingMemoization(int[] arr, int target, int idx, int sum, int[][] dp) {

        if (dp[idx][sum] != 0) return dp[idx][sum];
        if (idx == arr.length) return sum;
        if (arr[idx] + sum > target) return sum;

        int include = findNearestSubsetSumUsingMemoization(arr, target, idx + 1, sum + arr[idx], dp);
        int notInclude = findNearestSubsetSumUsingMemoization(arr, target, idx + 1, sum, dp);

        return dp[idx][sum] = Math.max(include, notInclude);

    }

    public static int findNearestSubsetSumUsingTabulation(int[] arr, int target, int[][] dp) {

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= target; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][i] = dp[i - 1][j];
                }

            }
        }

        return dp[arr.length][target];

    }

}
