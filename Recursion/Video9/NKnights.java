package Recursion.Video9;
import java.util.*;

public class NKnights {

    public static void main(String[] args) {

        knights(new boolean[3][3],0,0,3);

    }

    public static void knights(boolean[][] board,int row,int col,int knight){

        if(knight==0){
            for(boolean[] i : board){
                for(boolean j : i){
                    if(j) System.out.print("K ");
                    else System.out.print("O ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        if(row==board.length-1 && col==board.length) return;

        if(col==board.length) {
            knights(board,row+1,0,knight);
            return;
        }

        if(isSafe(board,row,col)){

            board[row][col]=true;
            knights(board,row,col+1,knight-1);
            board[row][col]=false;

        }

        knights(board,row,col+1,knight);
    }

    public static boolean isSafe(boolean[][] board,int row,int col){

        if(isValid(board,row-1,col-2)){
            if (board[row-1][col-2]) return false;
        }

        if(isValid(board,row-2,col-1)){
            if (board[row-2][col-1]) return false;
        }

        if(isValid(board,row-2,col+1)){
            if (board[row-2][col+1]) return false;
        }

        if(isValid(board,row-1,col+2)){
            if (board[row-1][col+2]) return false;
        }

        return true;

    }

    public static boolean isValid(boolean[][] board,int row,int col){

        return row >= 0 && row < board.length && col >= 0 && col < board.length;

    }

}
