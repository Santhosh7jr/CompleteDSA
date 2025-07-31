package Recursion.Video1.numbersProgram;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(binarySearch(new int[] {1,3,5,7,9},2,0,4));

    }

    public static int numbers(int n){
        System.out.println(numbers1(n-1));
        return n;
    }

    public static int numbers1(int n){
        System.out.println(numbers2(n-1));
        return n;
    }

    public static int numbers2(int n){
        System.out.println(numbers3(n-1));
        return n;
    }

    public static int numbers3(int n){
        System.out.println(numbers4(n-1));
        return n;
    }

    public static int numbers4(int n){
        return n;
    }

    //Q1: printing numbers using recursion
    public static void printNumbers(int n){
        if(n==6) return;
        System.out.println(n);
        printNumbers(n+1);
        if(n==5){
            printNumbers(n+1);
        }
    }

    //Q2: find nth fibonacci number
    public static int fibonacci(int n){
        if(n<=1) return n;

        return fibonacci(n-1)+fibonacci(n-2);
    }

    //Q3: binary search using recursion
    public static int binarySearch(int arr[],int target,int start,int end){
        if(start>end) return -1;

        int mid=(start+end)/2;

        if(arr[mid]==target) return mid;

        if(arr[mid]<target) return binarySearch(arr,target,mid+1,end);
        else return binarySearch(arr,target,start,mid-1);
    }

}
