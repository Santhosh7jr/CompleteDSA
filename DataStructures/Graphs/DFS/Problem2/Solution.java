package DataStructures.Graphs.DFS.Problem2;

//Q: (LeetCode - 200) Number of Islands
class Solution {
    public static int numIslands(char[][] grid) {
        int count=0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){

                if(grid[i][j]!='0' && !visited[i][j]){
                    count++;
                    dfs(i,j,grid,visited);
                }

            }
        }

        return count;
    }

    private static void dfs(int i,int j,char[][] grid,boolean visited[][]){

        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]=='0' || visited[i][j]) return;

        visited[i][j]=true;

        dfs(i-1,j,grid,visited);

        dfs(i,j+1,grid,visited);

        dfs(i+1,j,grid,visited);

        dfs(i,j-1,grid,visited);

    }

    public static void main(String[] args) {

        System.out.println(numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));

    }

}