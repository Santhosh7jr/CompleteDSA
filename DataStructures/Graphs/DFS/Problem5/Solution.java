package DataStructures.Graphs.DFS.Problem5;
import java.util.*;

// (LeetCode - 1020) Number of Enclaves

public class Solution {

    public static void main(String[] args) {

        System.out.println(numEnclaves(new int[][] {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));

    }

    public static int numEnclaves(int[][] grid) {

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            if(grid[i][0] == 1) dfs(grid, vis, i, 0);
            if(grid[i][grid[0].length - 1] == 1) dfs(grid, vis, i, grid[0].length - 1);
        }

        for (int i = 0; i < grid[0].length; i++) {
            if(grid[0][i] == 1) dfs(grid, vis, 0, i);
            if(grid[grid.length - 1][i] == 1) dfs(grid, vis, grid.length - 1, i);
        }

        for(int i = 1; i < grid.length - 1; i++) {
            for(int j = 1; j < grid[0].length - 1; j++) {
                if(!vis[i][j] && grid[i][j] == 1) count++;
            }
        }

        return count;

    }

    private static void dfs(int[][] grid, boolean[][] vis, int i, int j) {

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] || grid[i][j] == 0) return;

        vis[i][j] = true;

        dfs(grid, vis, i - 1, j);
        dfs(grid, vis, i, j + 1);
        dfs(grid, vis, i + 1, j);
        dfs(grid, vis, i, j - 1);

    }

}
