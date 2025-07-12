package Basics.Patterns.simplePatterns;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        zeroOneHalfTriangle(5);

    }

    public static void nCrossn(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
    }

    public static void hollowRectangle(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==n-1 || j==n-1){
                    System.out.print(" * ");
                }else {
                    System.out.print("   ");
                }
            }
            System.out.println(" ");
        }
    }

    public static void halfPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
    }

    public static void invertedHalfPyramid(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
    }

    public static void rotatedHalfPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print("   ");
            }
            for(int j=0;j<i;j++){
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
    }

    public static void halfNumericalPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                System.out.printf(" %d ",j+1);
            }
            System.out.println(" ");
        }
    }

    public static void invertedHalfNumericalPyramid(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.printf(" %d ",j+1);
            }
            System.out.println(" ");
        }
    }

    public static void floydTriangle(int n){
        int count=1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                System.out.printf(" %d ",count++);
            }
            System.out.println(" ");
        }
    }

    public static void zeroOneHalfTriangle(int n){
        int pattern=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                if(i%2==0 && j==0){
                    pattern=1;
                    System.out.printf(" %d ",pattern);
                    pattern=0;
                }else {
                    System.out.printf(" %d ",pattern);
                    pattern=(pattern==1) ? 0 : 1;
                }
            }
            System.out.println(" ");
        }
    }

}
