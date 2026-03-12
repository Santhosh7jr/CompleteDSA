package DynamicProgramming.UnboundedKnapsack.Variations.CoinChange_I;

public class Main {

    public static void main(String[] args) {

        int[] coins = {1, 2, 3};
        int sum = 5;

        System.out.println(findNumberOfWaysUsingRecursion(coins, sum, 0, 0));
        System.out.println(findNumberOfWaysUsingMemoization(coins, sum, 0, 0, new int[coins.length + 1][sum + 1]));
        System.out.println(findNumberOfWaysUsingTabulation(coins, sum));

    }

    public static int findNumberOfWaysUsingRecursion(int[] coins, int sum, int idx, int sumSoFar) {

        if (idx >= coins.length) return 0;

        if (sum == sumSoFar) {
            return 1;
        }

        if (sumSoFar > sum) return 0;

        int count1 = findNumberOfWaysUsingRecursion(coins, sum, idx, sumSoFar + coins[idx]);

        int count2 = findNumberOfWaysUsingRecursion(coins, sum, idx + 1, sumSoFar);

        return count1 + count2;

    }

    public static int findNumberOfWaysUsingMemoization(int[] coins, int sum, int idx, int sumSoFar, int[][] dp) {

        if (idx >= coins.length) return 0;

        if (dp[idx][sum] != 0) return dp[idx][sum];

        if (sum == sumSoFar) {
            return 1;
        }

        if (sumSoFar > sum) return 0;

        int count1 = findNumberOfWaysUsingMemoization(coins, sum, idx, sumSoFar + coins[idx], dp);

        int count2 = findNumberOfWaysUsingMemoization(coins, sum, idx + 1, sumSoFar, dp);

        return dp[idx][sum] = count1 + count2;

    }

    public static int findNumberOfWaysUsingTabulation(int[] coins, int target) {

        int[][] dp = new int[coins.length + 1][target + 1];

        for (int i = 0; i <= coins.length; i++) dp[i][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= target; j++) {

                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];                }

            }
        }

        return dp[coins.length][target];

    }

}
