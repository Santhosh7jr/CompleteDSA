package DataStructures.Graphs.BFS.Problem1;
import java.util.*;

//Q: (LeetCode - 994) Rotting Oranges
public class Solution {
    public static int orangesRotting(int[][] grid) {

        Queue<List<Integer>> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count=0;
        int result=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){

                if(grid[i][j]==1) count++;

                if(grid[i][j]==2){
                    q.offer(new ArrayList<>(Arrays.asList(i,j)));
                    visited[i][j]=true;
                }

            }
        }

        while(!q.isEmpty()) {
            int size = q.size();
            boolean rottedThisRound = false;

            for(int i=0; i<size; i++) {
                List<Integer> list = q.poll();
                int row = list.get(0);
                int col = list.get(1);

                if(isValid(row-1, col, visited, grid)) {
                    count--;
                    visited[row-1][col] = true;
                    grid[row-1][col] = 2;
                    q.offer(Arrays.asList(row-1, col));
                    rottedThisRound = true;
                }
                if(isValid(row, col+1, visited, grid)) {
                    count--;
                    visited[row][col+1] = true;
                    grid[row][col+1] = 2;
                    q.offer(Arrays.asList(row, col+1));
                    rottedThisRound = true;
                }
                if(isValid(row+1, col, visited, grid)) {
                    count--;
                    visited[row+1][col] = true;
                    grid[row+1][col] = 2;
                    q.offer(Arrays.asList(row+1, col));
                    rottedThisRound = true;
                }
                if(isValid(row, col-1, visited, grid)) {
                    count--;
                    visited[row][col-1] = true;
                    grid[row][col-1] = 2;
                    q.offer(Arrays.asList(row, col-1));
                    rottedThisRound = true;
                }
            }

            if(rottedThisRound) result++;
        }

        return (count == 0) ? result : -1 ;

    }

    private static boolean isValid(int i,int j,boolean[][] v,int[][] g){
        return i >= 0 && i < g.length && j >= 0 && j < g[i].length
                && !v[i][j] && g[i][j] == 1 ;
    }

    public static void main(String[] args) {

        System.out.println(orangesRotting(new int[][] {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        }));

    }

}