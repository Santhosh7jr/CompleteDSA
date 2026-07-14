package DynamicProgramming.Subsequences.Variations.LongestRepeatingSubsequence;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(getLongestRepeatingSubsequenceLength("abca"));

    }

    public static int getLongestRepeatingSubsequenceLength(String str) {

        int len = str.length();
        int[][] dp = new int[len + 1][len + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {

                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }

        return dp[len][len];

    }

}
