package Recursion.Video9;
import java.util.*;

public class NQueens_l {

    public static void main(String[] args) {

        for(List<String> list : queens(new boolean[5][5],0,new ArrayList<>())){
            System.out.println(list);
        }

    }

    //(LeetCode - 51) N-Queens
    public static List<List<String>> queens(boolean[][] board,int row,List<List<String>> list){

        if(row==board.length) {

            List<String> temp=new ArrayList<>();

            for(int i=0;i<board.length;i++){

                StringBuffer sb=new StringBuffer();

                for(int j=0;j<board.length;j++){

                    if(board[i][j]) sb.append('Q');
                    else sb.append('.');

                }
                temp.add(sb.toString());

            }
            list.add(temp);
            return list;

        }

        for(int col=0;col<board.length;col++){

            if(isSafe(board,row,col)){

                board[row][col]=true;
                queens(board,row+1,list);
                board[row][col]=false;

            }

        }

        return list;

    }

    public static boolean isSafe(boolean[][] board,int row,int col){

        for(int i=0;i<row;i++){
            if(board[i][col]) return false;
        }

        int left=Math.min(row,col);
        for(int i=1;i<=left;i++){
            if(board[row-i][col-i]) return false;
        }

        int right=Math.min(row,board.length-col-1);
        for(int i=1;i<=right;i++){
            if(board[row-i][col+i]) return false;
        }

        return true;

    }

}
