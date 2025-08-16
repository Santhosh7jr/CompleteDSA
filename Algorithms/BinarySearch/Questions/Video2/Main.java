package Algorithms.BinarySearch.Questions.Video2;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(searchingIn2D(new int[][] {
                {10,20,30,40},
                {15,25,36,46},
                {17,29,38,49},
                {19,34,42,55}
        },19)));

    }

    //searching in sorted array. sorted in both row-wise and column-wise.
    public static int[] searchingIn2D(int matrix[][],int target){

        int row=0;
        int column=matrix[row].length-1;

        while (row<matrix.length && column>=0){
            if(matrix[row][column]==target){
                return new int[] {row,column};
            }

            if(matrix[row][column]<target) row++;
            else column--;
        }

        return new int[] {-1,-1};
    }

}
