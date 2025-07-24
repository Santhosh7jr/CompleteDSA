package Algorithms.BubleSort;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(efficientBubleSort(new int[] {9,8,7,6,5,4,3,2,1})));

    }

    //Buble sort algorithm
    public static int[] bubleSort(int arr[]){

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        return arr;

    }

    //bubleSort with efficiency
    public static int[] efficientBubleSort(int arr[]){

        for(int i=0;i<arr.length-1;i++){
            boolean flag=true;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    flag=false;
                }
            }
            if(flag) break;
        }

        return arr;

    }

}
