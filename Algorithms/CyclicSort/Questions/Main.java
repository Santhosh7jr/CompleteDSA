package Algorithms.CyclicSort.Questions;
import java.util.*;

public class Main {

    public static void main(String[] args) {



    }

    public static void swap(int arr[],int src,int dest){
        int temp=arr[dest];
        arr[dest]=arr[src];
        arr[src]=temp;
    }

    //Q1: ( LeetCode - 268 ) missing number
    public static int missingNumber(int arr[]){

        int idx=0;

        while(idx<arr.length){

            int position=arr[idx];

            if(position<arr.length && arr[idx]!=arr[position]) swap(arr,idx,position);
            else idx++;

        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i) return i;
        }

        return arr.length;

    }

    //Q2: (LeetCode - 448) Find All Numbers Disappeared in an Array
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list=new ArrayList<>();

        int idx=0;

        while(idx!=nums.length){
            int position=nums[idx]-1;
            if(position<nums.length && nums[idx]!=nums[position]) swap(nums,idx,position);
            else idx++;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1) list.add(i+1);
        }

        return list;

    }

    //Q3: (LeetCode - 287) Find the Duplicate Number
    public int findDuplicate(int[] arr){

        int idx=0;

        while(idx!=arr.length){
            int position=arr[idx]-1;

            if(arr[idx]==arr[position] && idx!=position) return arr[idx];

            if(position<arr.length && arr[idx]!=arr[position]) swap(arr,idx,position);
            else idx++;

        }

        return -1;

    }

    //Q4: (LeetCode - 442) Find All Duplicates in an Array
    public static List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> list=new HashSet<>();

        int idx=0;

        while (idx<nums.length){
            int position=nums[idx]-1;

            if(nums[idx]==nums[position] && idx!=position) list.add(nums[idx]);

            if(position<nums.length && nums[idx]!=nums[position]) swap(nums,idx,position);
            else idx++;

        }

        return new ArrayList<>(list);
    }

    //Q5: (LeetCode - 645) Set Mismatch
    public static int[] findErrorNums(int[] arr) {
        int arr2[]=new int[2];
        int idx=0;

        while(idx!=arr.length){
            int position=arr[idx]-1;

            if(position<arr.length && arr[idx]!=arr[position]) swap(arr,idx,position);
            else idx++;

        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                arr2[0]=arr[i];
                arr2[1]=i+1;
                return arr2;
            }
        }

        return arr2;
    }

    //Q6: (LeetCode - 41) First Missing Positive
    public static int firstMissingPositive(int[] nums) {

        int idx=0;

        while(idx<nums.length){
            int position=-1;

            if(nums[idx]>=0) position=nums[idx]-1;

            if(position<nums.length && position!=-1 && nums[idx]!=nums[position]){
                int temp=nums[idx];
                nums[idx]=nums[position];
                nums[position]=temp;
            }else{
                idx++;
            }

        }

        int element=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==element) element++;
        }

        return element;

    }

}
