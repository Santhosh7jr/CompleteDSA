package Recursion.Video3;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(search(new int[] {3,4,5,1,2},5,0,4));

    }

    //Q1: finding if the array is sorted or not.
    public static boolean isSorted(int arr[],int idx){
        if(idx==arr.length-1) return true;

        if(arr[idx]>arr[idx+1]) return false;

        return isSorted(arr,idx+1);
    }

    //Q2: linear search using recursion
    public static int linearSearch(int arr[],int target,int idx){
        if (idx==arr.length) return -1;

        if (arr[idx]==target) return idx;

        return linearSearch(arr,target,idx+1);
    }
    
    //Q3: linear search for duplicate numbers
    public static List<Integer> linearSearch(int arr[],int target,int idx,List<Integer> list){
        if(idx==arr.length) return list;

        if (arr[idx]==target) list.add(idx);

        return linearSearch(arr,target,idx+1,list);
    }

    //Q4: linear search for duplicates but not taking the arraylist as parameter
    public static List<Integer> searchInArray(int arr[],int target,int idx){

        List<Integer> list=new ArrayList<>();

        if(idx==arr.length) return list;

        if(arr[idx]==target) list.add(idx);

        list.addAll(searchInArray(arr,target,idx+1));

        return list;

    }

    //Q5: search in rotated array
    public static int search(int arr[],int target,int start,int end){
        if(start>end) return -1;

        int mid=(start+end)/2;

        if(arr[mid]==target) return mid;

        if(arr[start]<=arr[mid]){
            if (arr[start]<=target && arr[mid]>=target) return search(arr,target,start,mid-1);
            else return search(arr,target,mid+1,end);
        }

        if(arr[mid]<=target && arr[end]>=target) return search(arr,target,mid+1,end);
        else return search(arr,target,start,mid-1);
    }

}
