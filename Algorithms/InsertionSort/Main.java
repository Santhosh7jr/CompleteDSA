package Algorithms.InsertionSort;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(insertionSort(new int[] {5,4,3,2,1,6,7,8,9,8,7,6,5,4})));

    }

    //insertion sort algorithm
    public static int[] insertionSort(int arr[]){

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }else {
                    break;
                }
            }
        }
        return arr;
    }

}
