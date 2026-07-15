package DynamicProgramming.MatrixChainMultiplication.Variations.PalindromePartition;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String str = "abcddeeddc";
        int len = str.length();

        int[][] dp = new int[len + 1][len + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println(getMinimumNumberOfPartitionsUsingRecursion(str, 0, len - 1));
        System.out.println(getMinimumNumberOfPartitionsUsingDP(str, 0, len - 1, dp));

    }

    public static int getMinimumNumberOfPartitionsUsingRecursion(String str, int left, int right) {

        if (left >= right) return 0;
        if (isPalindrome(str, left, right)) return 0;

        int result = Integer.MAX_VALUE;

        for (int k = left; k < right; k++) {

            result = Math.min(result, (
                    getMinimumNumberOfPartitionsUsingRecursion(str, left, k) +
                            getMinimumNumberOfPartitionsUsingRecursion(str, k + 1, right) + 1
                    ));

        }

        return result;

    }

    public static int getMinimumNumberOfPartitionsUsingDP(String str, int left, int right, int[][] dp) {

        if (left >= right) return 0;
        if (isPalindrome(str, left, right)) return 0;

        if (dp[left][right] != -1) return dp[left][right];

        int result = Integer.MAX_VALUE;

        for (int k = left; k < right; k++) {

            result = Math.min(result, (
                    getMinimumNumberOfPartitionsUsingDP(str, left, k, dp) +
                            getMinimumNumberOfPartitionsUsingDP(str, k + 1, right, dp) + 1
            ));

        }

        return dp[left][right] = result;

    }

    private static boolean isPalindrome(String str, int i, int j) {

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }

        return true;

    }

}
