package Algorithms.QuickSort;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(quickSort(new int[] {4,3,5,2,1},0,4)));

    }

    public static int[] quickSort(int arr[],int start,int end){
        if(start<end){
            int pidx=partition(arr,start,end);

            quickSort(arr,start,pidx-1);
            quickSort(arr,pidx+1,end);
        }
        return arr;
    }

    public static int partition(int arr[],int start,int end){

        int pivot=arr[end];
        int i=start-1;

        for(int j=start;j<end;j++){
            if(arr[j]<pivot){
                i++;

                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;

            }
        }

        i++;

        int temp=arr[i];
        arr[i]=pivot;
        arr[end]=temp;

        return i;

    }

}
