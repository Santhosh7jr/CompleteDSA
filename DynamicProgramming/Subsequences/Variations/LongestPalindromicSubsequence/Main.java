package DynamicProgramming.Subsequences.Variations.LongestPalindromicSubsequence;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String str = "adad";

        System.out.println(getLongestPalindromicSubsequenceLength(str));
        System.out.println(getLongestPalindromicSubsequence(str));

    }

    public static int getLongestPalindromicSubsequenceLength(String s) {

        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {

                if (s.charAt(i - 1) == s.charAt(len - j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[len][len];

    }

    public static String getLongestPalindromicSubsequence(String s) {

        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {

                if (s.charAt(i - 1) == s.charAt(len - j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return getLongestPalindromicSubsequence(s, dp);

    }

    private static String getLongestPalindromicSubsequence(String s, int[][] dp) {

        StringBuilder sb = new StringBuilder();

        int i = s.length();
        int j = s.length();

        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1]) {
                i--;
            } else {
                sb.append(s.charAt(i - 1));
                i--;
                j--;
            }
        }

        return sb.toString();

    }

}
