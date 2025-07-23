package Algorithms.BinarySearch.Implementation;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(ordAgnosticBS(new int[] {8,7,6,5,4,3,2,1},5));

    }

    //binary search algorithm
    public static boolean binarySearch(int arr[],int target){
        int start=0;
        int end=arr.length-1;

        while (start<=end){
            int mid=(start+end)/2;

            if(arr[mid]==target) return true;

            if(arr[mid]<target) start=mid+1;
            else end=mid-1;
        }

        return false;
    }

    //order agnostic binary search (here we don't know about the order of the array(ascending or descending))
    public static boolean ordAgnosticBS(int arr[],int target){
        int start=0;
        int end=arr.length-1;

        if(arr[start]==arr[end] && arr[start]==target) return true;

        if(arr[start]<arr[end]) return binarySearch(arr,target);
        else return descendingBS(arr,target);

    }

    //binary search for descending order
    public static boolean descendingBS(int arr[],int target){
        int start=0;
        int end=arr.length-1;

        while (start<=end){
            int mid=(start+end)/2;

            if(arr[mid]==target) return true;

            if(arr[mid]<target) start=mid-1;
            else end=mid+1;
        }

        return false;
    }

}
