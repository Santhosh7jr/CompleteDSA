package DataStructures.Graphs.DFS.Problem4;

// (LeetCode - 130) Surrounded Regions

import java.util.Arrays;

class Solution {
    public static char[][] solve(char[][] board) {

        boolean[][] vis = new boolean[board.length][board[0].length];

        for (int i = 0; i < board[0].length; i++) {

            if (board[0][i] == 'O') dfs(board, vis, 0, i);
            if (board[board.length - 1][i] == 'O') dfs(board, vis, board.length - 1, i);

        }

        for (int i = 0; i < board.length; i++) {

            if (board[i][0] == 'O') dfs(board, vis, i, 0);
            if (board[i][board[0].length-1] == 'O') dfs(board, vis, i, board[0].length-1);

        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if(!vis[i][j] && board[i][j] == 'O') board[i][j] = 'X';

            }
        }

        return board;

    }

    private static void dfs(char[][] board, boolean[][] vis, int i, int j) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || vis[i][j] || board[i][j] != 'O') return;

        vis[i][j] = true;

        dfs(board, vis, i - 1, j);
        dfs(board, vis, i, j+1);
        dfs(board, vis, i + 1, j);
        dfs(board, vis, i, j - 1);

    }

    public static void main(String[] args) {

        for (char[] row : solve(new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}})) {

            System.out.println(Arrays.toString(row));

        }

    }

}