package Algorithms.MergeSort;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(mergeSort(new int[] {3,4,5,2,1},0,4)));

    }

    public static int[] mergeSort(int arr[],int start,int end){

        if(start>=end) return arr;

        int mid=start+(end-start)/2;

        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);

        return arr;

    }

    public static void merge(int arr[],int start,int mid,int end){

        int temp[]=new int[end-start+1];

        int idx1=start;
        int idx2=mid+1;

        int x=0;

        while(idx1<=mid && idx2<=end){

            if(arr[idx1]<arr[idx2]) temp[x++]=arr[idx1++];
            else temp[x++]=arr[idx2++];

        }

        while (idx1<=mid) temp[x++]=arr[idx1++];

        while (idx2<=end) temp[x++]=arr[idx2++];

        for(int i=start,j=0;j<temp.length;i++,j++){
            arr[i]=temp[j];
        }

    }

}
