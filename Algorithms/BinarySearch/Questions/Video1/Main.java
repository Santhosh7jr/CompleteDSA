package Algorithms.BinarySearch.Questions.Video1;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(floorNumber(new int[] {2,4,6,7,8,9,11},1,0,6,-1));

    }

    //Q1: finding the number which is greater than or equal to the target element.
    public static int ceilingNumber(int arr[],int target,int start,int end,int answer){
        if(start>end) return answer;

        int mid=(start+end)/2;

        if(arr[mid]==target) return arr[mid];
        if(arr[mid]<target) return ceilingNumber(arr,target,mid+1,end,answer);
        else {
            answer=arr[mid];
            return ceilingNumber(arr,target,start,mid-1,answer);
        }
    }

    //Q2: finding the number which is lesser that or equal to the target element
    public static int floorNumber(int arr[],int target,int start,int end,int answer){
        if(start>end) return answer;

        int mid=(start+end)/2;

        if(arr[mid]==target) return arr[mid];
        if(arr[mid]<target){
            answer=arr[mid];
            return floorNumber(arr,target,mid+1,end,answer);
        }
        else return floorNumber(arr,target,start,mid-1,answer);
    }

    //Q3: (LeetCode - 744) --> Find Smallest Letter Greater Than Target
    public static char smallestLetter(char ch[],char target){
        int start=0;
        int end=ch.length-1;

        while(start<=end){
            int mid=(start+end)/2;

            if(ch[mid]<target) start=mid+1;
            else end=mid-1;
        }
        return ch[start % ch.length];
    }

    //Q4: (LeetCode - 34) find first and last position of an element in an sorted array
    public static int[] searchRange(int[] nums, int target) {
        int left=leftSearch(nums,target);
        int right=rightSearch(nums,target);

        return new int[] {left,right};
    }

    public static int leftSearch(int arr[],int target){
        int left=0;
        int right=arr.length-1;
        int result=-1;

        while(left<=right){
            int mid=(left+right)/2;

            if(arr[mid]==target){
                result=mid;
                right=mid-1;
            }
            else if(target<arr[mid]) right=mid-1;
            else left=mid+1;

        }

        return result;
    }

    public static int rightSearch(int arr[],int target){
        int left=0;
        int right=arr.length-1;
        int result=-1;

        while(left<=right){
            int mid=(left+right)/2;

            if(arr[mid]==target){
                result=mid;
                left=mid+1;
            }
            else if(target<arr[mid]) right=mid-1;
            else left=mid+1;

        }

        return result;
    }

    //Q5: position of an element in an infinite sorted array.
    public static int searchInInfiniteArray(int arr[],int target){
        int left=0;
        int right=1;

        while (arr[right]>target) right*=2;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(arr[mid]==target) return mid;

            if(arr[mid]<target) left=mid+1;
            else right=mid-1;
        }
        return -1;
    }

    //Q6: peak index in a mountain array.
    public int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;

        while(start!=end){
            int mid=(start+end)/2;

            if(arr[mid]>arr[mid+1]) end=mid;
            else start=mid+1;
        }

        return start;
    }

    //Q7: (LeetCode - 1095) Find in Mountain Array
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIdx=getPeak(mountainArr);

        int result=AscBS(mountainArr,target,0,peakIdx);

        return (result!=-1) ? result : DescBS(mountainArr,target,peakIdx+1,mountainArr.length()-1);
    }

    public static int AscBS(MountainArray mountainArr,int target,int start,int end){

        if(start>end) return -1;

        int mid=(start+end)/2;

        if(mountainArr.get(mid)==target) return mid;

        if(mountainArr.get(mid)<target) return AscBS(mountainArr,target,mid+1,end);

        else return AscBS(mountainArr,target,start,mid-1);

    }

    public static int DescBS(MountainArray mountainArr,int target,int start,int end){

        if(start>end) return -1;

        int mid=(start+end)/2;

        if(mountainArr.get(mid)==target) return mid;

        if(mountainArr.get(mid)<target) return DescBS(mountainArr,target,start,mid-1);

        else return DescBS(mountainArr,target,mid+1,end);

    }

    public static int getPeak(MountainArray mountainArr){
        int start=0;
        int end=mountainArr.length()-1;

        while(start!=end){
            int mid=(start+end)/2;

            if(mountainArr.get(mid)>mountainArr.get(mid+1)) end=mid;
            else start=mid+1;
        }

        return start;
    }

    //Q8: (LeetCode - 33) Search in Rotated Sorted Array
    public static int search(int[] nums, int target) {

        int pivot=getPivot(nums,0,nums.length-1);

        int result = bs(nums,target,0,pivot);

        return (result!=-1) ? result : bs(nums,target,pivot+1,nums.length-1);
    }

    public static int getPivot(int nums[],int start,int end){

        if(start>end) return 0;

        int mid=(start+end)/2;

        if(mid+1<nums.length && nums[mid]>nums[mid+1]) return mid;

        if(mid-1>=0 && nums[mid]<nums[mid-1]) return mid-1;

        if(nums[mid]<nums[0]) return getPivot(nums,start,mid-1);

        else return getPivot(nums,mid+1,end);

    }

    public static int bs(int nums[],int target,int start,int end){

        if(start>end) return -1;

        int mid=(start+end)/2;

        if(nums[mid]==target) return mid;

        if(nums[mid]<target) return bs(nums,target,mid+1,end);
        else return bs(nums,target,start,mid-1);

    }

//    Q10: count number of rotations in a sorted array
    public static int rotationCount(int nums[],int start,int end){
        if(start>end) return 0;

        int mid=(start+end)/2;

        if(mid+1<nums.length && nums[mid]>nums[mid+1]) return mid+1;

        if(mid-1>=0 && nums[mid]<nums[mid-1]) return mid;

        if(nums[mid]<nums[0]) return getPivot(nums,start,mid-1);

        else return getPivot(nums,mid+1,end);
    }

    //Q11: (LeetCode - 410) Split Array Largest Sum.
    public static int splitArray(int[] nums, int k) {
        int start=0;
        int end=0;

        for(int i:nums){
            start=Math.max(i,start);
            end+=i;
        }

        while(start<end){

            int mid=start+(end-start)/2;

            int sum=0;
            int pieces=1;

            for(int num:nums){
                if(sum+num>mid){
                    sum=num;
                    pieces++;
                }else{
                    sum+=num;
                }
            }

            if(pieces>k) start=mid+1;
            else end=mid;

        }

        return start;

    }
}
