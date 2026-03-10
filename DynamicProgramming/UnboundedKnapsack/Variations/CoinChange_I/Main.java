package DynamicProgramming.UnboundedKnapsack.Variations.CoinChange_I;

public class Main {

    public static void main(String[] args) {

        int[] coins = {1, 2, 3};
        int sum = 5;

        System.out.println(findNumberOfWaysUsingRecursion(coins, sum, 0, 0, new int[1]));
        System.out.println(findNumberOfWaysUsingTabulation(coins, sum));

    }

    public static int findNumberOfWaysUsingRecursion(int[] coins, int sum, int idx, int sumSoFar, int[] result) {

        if (idx >= coins.length) return result[0];

        if (sum == sumSoFar) {
            return ++result[0];
        }

        if (sumSoFar > sum) return result[0];

        findNumberOfWaysUsingRecursion(coins, sum, idx, sumSoFar + coins[idx], result);

        findNumberOfWaysUsingRecursion(coins, sum, idx + 1, sumSoFar, result);

        return result[0];

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
