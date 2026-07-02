package DynamicProgramming.Subsequences.Variations.LCSubstrings;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String s1 = "abcabcbb";
        String s2 = "abcbb";

        System.out.println(getLongestCommonSubstringLengthUsingRecursion(s1, s2, 0, 0, 0));
        System.out.println(getLongestCommonSubstringLengthUsingTabulation(s1, s2));
        System.out.println(printingLCSubstring(s1, s2));

    }

    public static int getLongestCommonSubstringLengthUsingRecursion(String s1, String s2, int idx1, int idx2, int count) {

        if (idx1 == s1.length() || idx2 == s2.length()) return count;

        int currentCount = count;

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            currentCount = getLongestCommonSubstringLengthUsingRecursion(s1, s2, idx1 + 1, idx2 + 1, count + 1);
        }

        return Math.max(currentCount, Math.max(
            getLongestCommonSubstringLengthUsingRecursion(s1, s2, idx1 + 1, idx2, 0),
            getLongestCommonSubstringLengthUsingRecursion(s1, s2, idx1, idx2 + 1, 0)
        ));
    }

    public static int getLongestCommonSubstringLengthUsingTabulation(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        int max = 0;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }

            }
        }

        return max;

    }

    public static String printingLCSubstring(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        int max = 0;
        int x = 0;
        int y = 0;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        x = i;
                        y = j;
                    }

                } else {
                    dp[i][j] = 0;
                }

            }
        }

        return getString(s1, dp, x, y);

    }

    private static String getString(String s1, int[][] dp, int x, int y) {

        StringBuilder result = new StringBuilder();

        while (dp[x][y] != 0) {
            result.insert(0, s1.charAt(x - 1));
            x--;
            y--;
        }

        return result.toString();

    }

}
