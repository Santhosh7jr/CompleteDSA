package DynamicProgramming.MatrixChainMultiplication.Implementation;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] matrixDimensions = {40, 20, 30, 10, 30};
        int len = matrixDimensions.length;
        int[][] dp = new int[len + 1][len + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println(getMinimumNumberOfMultiplicationsRequired(matrixDimensions, 1, len - 1));
        System.out.println(getMinimumNumberOfMultiplicationsRequiredUsingRecursion(matrixDimensions, 1, len - 1, dp));

    }

    public static int getMinimumNumberOfMultiplicationsRequired(int[] arr, int left, int right) {

        if (left >= right) return 0;

        int min = Integer.MAX_VALUE;

        for (int i = left; i < right; i++) {
            min = Math.min(min,
                    (
                        getMinimumNumberOfMultiplicationsRequired(arr, left, i) +
                        getMinimumNumberOfMultiplicationsRequired(arr, i + 1, right) +
                        (arr[left - 1] * arr[i] * arr[right])
                    ));
        }

        return min;

    }

    public static int getMinimumNumberOfMultiplicationsRequiredUsingRecursion(int[] arr, int left, int right, int[][] dp) {

        if (left >= right) return 0;
        if (dp[left][right] != -1) return dp[left][right];

        int min = Integer.MAX_VALUE;

        for (int i = left; i < right; i++) {
            min = Math.min(min,
                    (
                            getMinimumNumberOfMultiplicationsRequiredUsingRecursion(arr, left, i, dp) +
                                    getMinimumNumberOfMultiplicationsRequiredUsingRecursion(arr, i + 1, right, dp) +
                                    (arr[left - 1] * arr[i] * arr[right])
                    ));
        }

        return dp[left][right] = min;

    }

}
