package DynamicProgramming.Subsequences.Variations.ShortestCommonSupersequence;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "gxtxayb";
        String[][] dp = new String[s1.length() + 1][s2.length() + 1];

        List<String> allSupersequences = new ArrayList<>();
        getAllShortestCommonSupersequences(s1, s2, 0, 0, "", allSupersequences);
        String supersequenceWithMinLength = getMinSupersequence(allSupersequences);
        System.out.println(allSupersequences);
        System.out.println(supersequenceWithMinLength);
        System.out.println(shortestCommonSupersequenceLength(s1, s2));

    }

    public static void getAllShortestCommonSupersequences(String s1, String s2, int idx1, int idx2, String s, List<String> list) {

        if (idx1 == s1.length() || idx2 == s2.length()) {
            if (idx1 == s1.length()) list.add(s + s2.substring(idx2));
            else list.add(s + s1.substring(idx1));

            return;
        }

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            getAllShortestCommonSupersequences(s1, s2, idx1 + 1, idx2 + 1, s + s1.charAt(idx1), list);
        } else {
            getAllShortestCommonSupersequences(s1, s2, idx1 + 1, idx2, s + s1.charAt(idx1), list);
            getAllShortestCommonSupersequences(s1, s2, idx1, idx2 + 1, s + s2.charAt(idx2), list);
        }

    }

    public static String getMinSupersequence(List<String> list) {

        String s = list.get(0);

        for (String str : list) s = ((s.length() < str.length()) ? s : str);

        return s;

    }

    public static int shortestCommonSupersequenceLength(String s1, String s2) {

        int x = s1.length();
        int y = s2.length();
        int[][] dp = new int[x + 1][y + 1];

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = (1 + dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        for (int[] row : dp) System.out.println(Arrays.toString(row));

        return x + y - dp[x][y];

    }

}
