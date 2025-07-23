package Algorithms.LinearSearch;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(maxWealth(new int[][] {{2,8,7},{7,1,3},{1,9,5}}));

    }

    //linear search algorithm
    public static boolean linearSearch(int arr[],int target){

        for(int i:arr){
            if(i==target) return true;
        }

        return false;
    }

    //Q1: searching a character in a string
    public static boolean searchChar(String str,char target){

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==target) return true;
        }

        return false;

    }

    //Q2: searching in between a particular range (Inclusive)
    public static boolean searchInRange(int arr[],int terget,int start,int end){
        if(start>=arr.length || end>=arr.length) return false;

        for(int i=start;i<=end;i++){
            if(arr[i]==terget) return true;
        }

        return false;
    }

    //Q3: finding the minimum number
    public static int findMin(int arr[]){
        int min=Integer.MAX_VALUE;

        for (int j : arr) {
            if (j < min) min = j;
        }

        return min;
    }

    //Q4: search in 2D array
    public static boolean searchIn2D(int arr[][],int target){
        for(int i[]: arr){
            for (int j:i){
                if (j==target) return true;
            }
        }

        return false;
    }

    //Q5: even number if digits --> LeetCode-1295
    public static int evenDigitCount(int arr[]){
        int digitCount=0;

        for(int i:arr){
            if(isEvenDigit(i)) digitCount++;
        }

        return digitCount;
    }

    //finding if the number has even digits
    public static boolean isEvenDigit(int n){
        int count=0;

        while (n!=0){
            count++;
            n/=10;
        }

        return count%2==0;
    }

    //easy way to find out the number with even digits
    public static boolean isEvenDigit2(int n){
        return ((int) (Math.log10(n))+1) % 2 == 0;
    }

    //Q6: richest customer wealth --> LeetCode-1672
    public static int maxWealth(int wealth[][]){

        int maxWealthSum=0;

        for(int bank[] :wealth){
            int localWealthSum=0;

            for(int account:bank){
                localWealthSum+=account;
            }
            maxWealthSum=Math.max(maxWealthSum,localWealthSum);
        }

        return maxWealthSum;

    }

}
