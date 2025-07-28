package Algorithms.CyclicSort.Implementation;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(cyclicSort(new int[] {2,3,4,1,5,8,7,6,9})));

    }

    //cyclic sort algorithm
    public static int[] cyclicSort(int arr[]){

        int idx=0;

        while(idx!=arr.length){
            int position=arr[idx]-1;

            if(arr[idx]!=arr[position]) swap(arr,idx,position);
            else idx++;

        }
        return arr;

    }
    public static void swap(int arr[],int src,int dest){
        int temp=arr[src];
        arr[src]=arr[dest];
        arr[dest]=temp;
    }

}
