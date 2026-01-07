package Greedy.AssignCookies;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] g = {1,2};
        int[] s = {1,2, 3};

        System.out.println(findContentChildren(g, s));

    }

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int sIdx = s.length - 1;

        for (int i = g.length - 1; i >= 0; i--) {

            if (g[i] <= s[sIdx]) {
                count++;
                sIdx--;
            }

        }

        return count;

    }

}
