package Basics.Math.M1;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*{
            int num = Integer.MAX_VALUE;
            StringBuilder s = new StringBuilder();
            int i = 31;

            while (i >= 0) {
                s.append(((num & (1 << i)) == 0) ? "0" : "1");
                i--;
            }
            System.out.println(s);
        }*/

        System.out.println(findXor(3,9));


    }
    //Question1 : finding whether the number is even or odd
    public static String evenOrOdd(int n){
        return ((n&1)==0) ? "Even" : "Odd";
    }

    //Question2: finding number that appears only once in an array and all the other numbers appear exactly twice
    public static int findNum(int[] arr){
        int num=0;
        for (int i : arr) {
            num ^= i;
        }

        return num;
    }

    //Question3: finding the number which does not having its negative in the array but all the other numbers do.
    public static int findNum2(int arr[]){
        int num=0;
        for (int i : arr) {
            num += i;
        }

        return num;
    }

    //Question4: finding the ith bit
    public static int findBit(int n,int i){
        return ((n & (1<<i))==0) ? 0 : 1;
    }

    //Question5: set the ith bit (if ith bit==0 then convert it into 1 else leave it as it is)
    public static int setBit(int n,int i){
        return n | (1<<i);
    }

    //Question6: reset the ith bit (if ith bit==0 then convert it into 1 else convert it into 0)
    public static int resetBit(int n,int i){
        return ((n & (1<<i))==0) ? (n | (1<<i)) : (n & ~(1<<i));
    }

    //Question7:find the position of the right most set bit
    public static int findPosition(int n){
        int position=0;
        int i=1;

        while ((n & i)==0){
            i<<=1;
            position++;
        }
        return position;

    }

    //Question8: finding the number which is appearing only once in an array and all the others are appearing thrice/odd times.
    public static int findNum3(int arr[]){
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int mask = 1 << i;

            for (int num : arr) {
                if ((num & mask) != 0) {
                    sum++;
                }
            }

            if (sum % 3 != 0) {
                result |= mask;
            }
        }

        return result;
    }

    //Question9: finding the nth magic number
    public static long findMagicNumber(int n){

        long answer=0;
        long power=5;

        while (n!=0){

            if((n & 1)!=0) answer+=power;
            power*=5;
            n>>=1;

        }

        return answer;

    }

    //Question10: number of bits
    public static int numberOfBits(int n){
        //return (int) (Math.log(n) / Math.log(2) + 1);

        int count=0;

        while (n!=0){
            count++;
            n>>=1;
        }
        return count;
    }

    //Question11: find the sum of nth row of the pascal's triangle
    public static int findSum(int n){
        return 1<<n-1;
    }

    //Question12: find whether the number is power of two or not
    public static boolean powerOfTwo(int n){
        //return (n & (n-1)) == 0;

        int count=0;

        while (n!=0){
            if((n&1)!=0) count++;
            n>>=1;
        }

        return count==1;

    }

    //Question13: find a power b
    public static int findPower(int a,int b){
        int result=1;
        int base=a;

        while(b!=0){
            if((b & 1)!=0) result*=base;
            base*=base;
            b>>=1;
        }
        return result;
    }

    //Question14: find the number of set bits in number n.
    public static int numberOfSetBits(int n){
        int count=0;

        while (n!=0){
            if((n & 1)==1) count++;
            n>>=1;
        }
        return count;
    }

    //Question15: XOR of numbers from 0 till n
    public static int findXor(int n){

        /*int result=0;

        for(int i=1;i<=n;i++){
            result ^= i;
        }

        return result;*/

        if(n%4==0) return n;
        if(n%4==1) return 1;
        if(n%4==2) return n+1;
        else return 0;

    }

    //Question16: XOR of numbers from a to b
    public static int findXor(int a,int b){
        return findXor(b)^findXor(a-1);
    }

    //Question17: flipping an image (LeetCode-832 -> by Google)
    public static int[][] flipAndInvertImage(int[][] image) {

        for(int i=0;i<image.length;i++){
            for(int j=0,k=image.length-1;j<(image.length+1)/2;j++,k--){
                int temp=image[i][j]^1;
                image[i][j]=image[i][k]^1;
                image[i][k]=temp;
            }
        }

        return image;
    }
}
