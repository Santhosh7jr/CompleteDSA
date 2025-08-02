package Recursion.Video4;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(selectionSort(new int[] {2,3,5,4,1,7,6},6)));

    }

    //Q1: triangle 1
    public static void printTriangle(int row,int column){
        if(row==0) return;

        if(column==0) {
            System.out.println(" ");
            printTriangle(row - 1, row-1);
        }else {
            System.out.print(" * ");
            printTriangle(row,column-1);
        }
    }

    //Q2: triangle 2
    public static void printTriangle2(int row,int column,int count){
        if (row==0) return;

        if(column==count){
            System.out.println(" ");
            printTriangle2(row-1,0,count+1);
        }else {
            System.out.print(" * ");
            printTriangle2(row,column+1,count);
        }
    }

    // triangle 2 without third variable
    public static void printTriangle2(int row,int column){
        if(row==0) return;

        if(column<row){
            printTriangle2(row,column+1);
            System.out.print(" * ");
        }else {
            printTriangle2(row-1,0);
            System.out.println(" ");
        }
    }

    //Q3: buble sort algorithm
    public static int[] bubleSort(int arr[],int i,int j){
        if(i==0) return arr;

        if(j==i-1) return bubleSort(arr,i-1,0);

        if(arr[j]>arr[j+1]) swap(arr,j,j+1);

        return bubleSort(arr,i,j+1);
    }

    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //Q4: selectionSort algorithm
    public static int[] selectionSort(int arr[],int i){
        if(i<0) return arr;

        int max=getMax(arr,i);

        swap(arr,i,max);

        return selectionSort(arr,i-1);

    }

    public static int getMax(int arr[],int n){

        int max=0;

        for(int i=1;i<=n;i++){
            if(arr[i]>arr[max]) max=i;
        }

        return max;

    }

}
