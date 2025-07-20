package Basics.BitManipulation;
import java.util.*;



public class Main {

    public static void main(String[] args) {

        System.out.println(updateBit(5,3));

    }

    public static int getBit(int n,int position){
        return ((n & 1<<position)==0) ? 0 : 1;
    }

    public static int setBit(int n,int position){
        return n | 1<<position;
    }

    public static int clearBit(int n,int position){
        return n & ~(1<<position);
    }

    public static int updateBit(int n,int position){
        return ((n & (1<<position))==0) ? setBit(n,position) : clearBit(n,position) ;
    }

}
