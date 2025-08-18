package DataStructures.Graphs.BFS.Problem2;
import java.util.*;


//Q: (LeetCode - 542) 01 Matrix
public class Solution {
    public static int[][] updateMatrix(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int[][] result = new int[mat.length][mat[0].length];
        Queue<List<Integer>> q = new LinkedList<>();

        for(int i = 0; i < mat.length; i++){

            for(int j = 0; j < mat[0].length; j++){

                if(mat[i][j] == 0) {

                    q.offer(new ArrayList<>(Arrays.asList(i,j,0)));
                    visited[i][j] = true;

                }

            }

        }

        while(!q.isEmpty()){

            List<Integer> list = q.poll();
            int row = list.get(0);
            int col = list.get(1);
            int val = list.get(2);

            result[row][col] = val;

            int rows[] = {-1, 0, 1, 0};
            int cols[] = {0, 1, 0, -1};

            for(int i = 0; i < 4; i++){

                int idx1 = row + rows[i];
                int idx2 = col + cols[i];

                if(idx1 >= 0 && idx1 < mat.length && idx2 >= 0 && idx2 < mat[0].length && !visited[idx1][idx2]){

                    visited[idx1][idx2] = true;
                    q.offer(new ArrayList<>(Arrays.asList(idx1, idx2, val+1)));

                }

            }

        }

        return result;

    }

    public static void main(String[] args) {

        int[][] result = updateMatrix(new int[][] {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        });

        for (int[] rows : result) System.out.println(Arrays.toString(rows));

    }

}
