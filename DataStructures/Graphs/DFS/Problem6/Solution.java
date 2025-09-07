package DataStructures.Graphs.DFS.Problem6;
import java.util.*;

//https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
public class Solution {

    public static void main(String[] args) {

        System.out.println(countDistinctIslands(new int[][] {
                        {1, 1, 0, 1, 1},
                        {1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1},
                        {1, 1, 0, 1, 1}
        }));

    }

    public static int countDistinctIslands(int[][] grid) {

        HashSet<HashSet<List<Integer>>> set = new HashSet<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1 && ! vis[i][j]){

                    HashSet<List<Integer>> childSet = new HashSet<>();
                    set.add(dfs(grid, vis, i, j, childSet, i, j));
                }

            }
        }

        return set.size();

    }

    private static HashSet<List<Integer>> dfs(int[][] grid, boolean[][] vis, int i, int j, HashSet<List<Integer>> set, int x, int y) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || vis[i][j]) return set;

        vis[i][j] = true;
        set.add(new ArrayList<>(Arrays.asList(x - i, y - j)));

        dfs(grid,vis,i - 1, j, set, x, y);
        dfs(grid,vis,i, j + 1, set, x, y);
        dfs(grid,vis,i + 1, j, set, x, y);
        dfs(grid,vis,i, j - 1, set, x, y);

        return set;

    }

}
