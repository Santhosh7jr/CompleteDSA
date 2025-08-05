package Recursion.Video7;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(combinationSum(new int[] {1,2,3,4},0,4,new ArrayList<>(),""));

    }

    //Q1: (LeetCode - 17) Letter Combinations of a Phone Number
    static String keypad[]={" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static List<String> letterCombination(String digit,String dest,List<String> list){

        if(digit.isEmpty()){
            list.add(dest);
            return list;
        }

        char ch=digit.charAt(0);

        for (int i=0;i<keypad[ch-'0'].length();i++){

            letterCombination(digit.substring(1),dest+keypad[ch-'0'].charAt(i),list);

        }

        return list;
    }

    //Q2: combination sum
    public static List<String> combinationSum(int arr[],int count,int target,List<String> list,String str){

        if(count>=target){
            if(count==target) list.add(str);
            return list;
        }

        for (int j : arr) {
            combinationSum(arr, count + j, target, list, str + j);
        }

        return list;

    }

}
