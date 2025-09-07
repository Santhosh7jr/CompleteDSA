package DataStructures.Graphs.BruteForce.Problem1;
import java.util.*;

//https://www.geeksforgeeks.org/problems/bipartite-graph/1
public class Solution {

    public static void main(String[] args) {

        System.out.println(isBipartite( 4, new int[][] {{0, 3}, {1, 2}, {3, 2}, {0, 2}}));

    }

    public static boolean isBipartite(int V, int[][] edges) {

        int[] tracker = new int[V];
        boolean[] vis = new boolean[V];
        int flag = 1;

        for (int[] edge : edges) {

            if (vis[edge[0]] && vis[edge[1]] && tracker[edge[0]] == tracker[edge[1]]) return false;

            if (! vis[edge[0]]) {
                vis[edge[0]] = true;
                tracker[edge[0]] = flag;
                flag *= -1;
            }

            if (! vis[edge[1]]) {
                vis[edge[1]] = true;
                tracker[edge[1]] = flag;
                flag *= -1;
            }

        }

        return true;

    }

}
