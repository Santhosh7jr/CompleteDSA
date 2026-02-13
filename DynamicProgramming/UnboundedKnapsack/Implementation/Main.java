package DynamicProgramming.UnboundedKnapsack.Implementation;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] weight = {1, 2, 4, 5};
        int[] value = {1, 4, 5, 7};

        int W = 7;

        int[][] dp = new int[weight.length + 1][W + 1];

        System.out.println(getMaximumPossibleValueSum(weight, value, W, dp));

        getElementsInvolved(weight, value, W, dp);

    }

    public static int getMaximumPossibleValueSum(int[] weight, int[] value, int W, int[][] dp) {

        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= W; j++) {

                if (weight[i - 1] <= j) dp[i][j] = Math.max(value[i - 1] + dp[i][j - weight[i - 1]], dp[i - 1][j]);
                else dp[i][j] = dp[i - 1][j];

            }
        }

        return dp[dp.length - 1][dp[0].length - 1];

    }

    public static void getElementsInvolved(int[] weights, int[] values, int W, int[][] dp) {

        int i = dp.length - 1;
        int j = dp[0].length - 1;

        List<Integer> involvedNumbers = new ArrayList<>();

        while (i > 0 && j > 0) {

            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                involvedNumbers.add(values[i - 1]);
                j -= weights[i - 1];
            }

        }

        System.out.println(involvedNumbers);

    }

}
