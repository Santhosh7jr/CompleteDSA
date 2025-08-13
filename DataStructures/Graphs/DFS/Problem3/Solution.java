package DataStructures.Graphs.DFS.Problem3;

import java.util.Arrays;

//Q: (LeetCode - 733) Flood Fill
class Solution {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int init = image[sr][sc];
        boolean[][] visited=new boolean[image.length][image[0].length];

        if(init == color) return image;

        return dfs(image,visited,sr,sc,color,init);
    }

    private static int[][] dfs(int[][] image,boolean[][] visited,int i,int j,int c,int in){

        if(i<0 || j<0 || i>=image.length || j>=image[i].length ||
                image[i][j]!=in || visited[i][j]) return image;

        visited[i][j]=true;
        image[i][j]=c;

        dfs(image,visited,i-1,j,c,in);

        dfs(image,visited,i,j+1,c,in);

        dfs(image,visited,i+1,j,c,in);

        dfs(image,visited,i,j-1,c,in);

        return image;

    }

    public static void main(String[] args) {

        int[][] result = floodFill(new int[][]{
                {1,1,1},
                {1,1,0},
                {1,0,1}
        },1,1,2);

        for (int[] row : result){
            System.out.println(Arrays.toString(row));
        }

    }

}