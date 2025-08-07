package Recursion.Video9;

public class NQueens_ll {

    public static void main(String[] args) {

        System.out.println(queens(new boolean[2][2],0));

    }

    //(LeetCode - 52) N-Queens II
    public static int queens(boolean[][] board,int row){

        if(row==board.length) {

            for (boolean bool[] : board){
                for(boolean b : bool){

                    if (b){
                        System.out.print("Q ");
                    }else {
                        System.out.print("X ");
                    }

                }
                System.out.println(" ");
            }
            System.out.println(" ");

            return 1;
        }

        int count=0;

        for(int col=0;col<board.length;col++){

            if(isSafe(board,row,col)){

                board[row][col]=true;

                count+= queens(board,row+1);

                board[row][col]=false;

            }

        }

        return count;

    }

    public static boolean isSafe(boolean[][] board,int row,int col){

        for(int i=0;i<row;i++){
            if(board[i][col]) return false;
        }

        int maxLeft=Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i]) return false;
        }

        int maxRight=Math.min(row,board.length-col-1);
        for (int i=1;i<=maxRight;i++){
            if(board[row-i][col+i]) return false;
        }

        return true;

    }


}
