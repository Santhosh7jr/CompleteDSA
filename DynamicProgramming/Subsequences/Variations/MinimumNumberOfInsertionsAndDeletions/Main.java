package DynamicProgramming.Subsequences.Variations.MinimumNumberOfInsertionsAndDeletions;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String a = "xyz";
        String b = "abcxyzl";

        System.out.println(getSumOfMinimumInsertionsAndDeletions(a, b));

    }

    public static int getSumOfMinimumInsertionsAndDeletions(String a, String b) {

        int x = a.length();
        int y = b.length();
        int[][] dp = new int[x + 1][y + 1];

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return ((x - dp[x][y]) + (y - dp[x][y]));

    }

}
