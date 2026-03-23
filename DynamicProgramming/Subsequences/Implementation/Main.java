package DynamicProgramming.Subsequences.Implementation;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println(getSubSequenceCountUsingRecursion(s1, s2, 0, 0));
        System.out.println(getSubSequenceCountUsingMemoization(s1, s2, 0, 0, dp));
        System.out.println(getSubSequenceCountUsingTabulation(s1, s2));

    }

    public static int getSubSequenceCountUsingRecursion(String s1, String s2, int idx1, int idx2) {

        if (idx1 == s1.length() || idx2 == s2.length()) return 0;

        if (s1.charAt(idx1) == s2.charAt(idx2)) return 1 + getSubSequenceCountUsingRecursion(s1, s2, idx1 + 1, idx2 + 1);

        return Math.max(
          getSubSequenceCountUsingRecursion(s1, s2, idx1 + 1, idx2),
          getSubSequenceCountUsingRecursion(s1, s2, idx1, idx2 + 1)
        );

    }

    public static int getSubSequenceCountUsingMemoization(String s1, String s2, int idx1, int idx2, int[][] dp) {

        if (idx1 == s1.length() || idx2 == s2.length()) return 0;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if (s1.charAt(idx1) == s2.charAt(idx2)) return dp[idx1][idx2] = 1 + getSubSequenceCountUsingMemoization(s1, s2, idx1 + 1, idx2 + 1, dp);

        return dp[idx1][idx2] = Math.max(
                getSubSequenceCountUsingMemoization(s1, s2, idx1 + 1, idx2, dp),
                getSubSequenceCountUsingMemoization(s1, s2, idx1, idx2 + 1, dp)
        );

    }

    public static int getSubSequenceCountUsingTabulation(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[s1.length()][s2.length()];

    }

}
