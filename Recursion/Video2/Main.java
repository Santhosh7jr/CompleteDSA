package Recursion.Video2;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(reduceToZero(14));

    }

    //Q1: print numbers n to 1
    public static void nTo1(int n){
        if(n<1) return;

        System.out.print(n+" ");
        nTo1(n-1);
    }

    //Q2: print numbers 1 to n
    public static void oneTon(int n){
        if(n<1) return;

        oneTon(n-1);
        System.out.print(n+" ");
    }

    //Q3: product of n to 1
    public static int product(int n,int prod){
        if(n==1) return prod;

        return product(n-1,prod*n);
    }

    //Q4: sum of n to 1
    public static int sum(int n){
        if(n==1) return n;

        return n+sum(n-1);
    }

    //Q5: sum of digits
    public static int digitSum(int digit,int sum){
        if(digit==0) return sum;

        return digitSum(digit/10,sum+(digit%10));
    }

    //Q6: product of digits
    public static int digitProduct(int digit,int product){
        if(digit==0) return product;

        return digitProduct(digit/10,product*(digit%10));
    }

    //Q7: reverse a number
    public static String numberReverse(int n,String str){
        if(n==0) return str;

        return numberReverse(n/10,str+(n%10));
    }

    //Q7: second method to reverse a number
    public static int numberReverse(int n,int reversed){
        if(n==0) return reversed;

        return numberReverse(n/10,(reversed*10)+n%10);
    }

    //Q8: check whether the number is palindrome or not
    public static boolean palindrome(int n){
        return n==(numberReverse(n,0));
    }

    //Q9: count the number of zeros in the number
    public static int countZeros(int n){
        if(n==0) return 0;

        return (n%10==0) ? 1+countZeros(n/10) : countZeros(n/10);
    }

    //Q10: (LeetCode - 1342) Number of Steps to Reduce a Number to Zero
    public static int reduceToZero(int num){
        if(num==0) return 0;

        return (num%2==0) ? 1+reduceToZero(num/2) : 1+reduceToZero(num-1);
    }

}
