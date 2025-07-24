package Algorithms.SelectionSort;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(selectionSort(new int[] {6,5,4,3,5,4,8,9,7,2,2,1})));

    }

    //selection sort algorithm
    public static int[] selectionSort(int arr[]){

        for(int i=0;i<arr.length-1;i++){
            int minIdx=getMinIdx(arr,i,arr.length-1);

            int temp=arr[i];
            arr[i]=arr[minIdx];
            arr[minIdx]=temp;
        }

        return arr;

    }

    public static int getMinIdx(int arr[],int start,int end){
        int minIdx=start;

        for(int i=start+1;i<=end;i++){
            if(arr[minIdx]>arr[i]) minIdx=i;
        }

        return minIdx;
    }

}
