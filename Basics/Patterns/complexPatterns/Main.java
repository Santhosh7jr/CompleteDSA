package Basics.Patterns.complexPatterns;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        butterflyPattern(5);

    }

    public static void butterflyPattern(int n){

        for(int i=0;i<n;i++){

            for(int j=0;j<=i;j++){
                System.out.print(" * ");
            }

            for(int j=0;j<(n-i-1)*2;j++){
                System.out.print("   ");
            }

            for(int j=0;j<=i;j++){
                System.out.print(" * ");
            }

            System.out.println(" ");

        }

        for(int i=0;i<n;i++){

            for(int j=0;j<n-i;j++){
                System.out.print(" * ");
            }

            for(int j=0;j<(i)*2;j++){
                System.out.print("   ");
            }

            for(int j=0;j<n-i;j++){
                System.out.print(" * ");
            }

            System.out.println(" ");

        }
    }

    public static void solidRhombus(int n){

        for(int i=0;i<n;i++){

            for(int j=0;j<n-i;j++){
                System.out.print("   ");
            }

            for(int j=0;j<n;j++){
                System.out.print(" * ");
            }

            System.out.println(" ");

        }

    }

    public static void numberPyramid(int n){

        for(int i=0;i<n;i++){

            for(int j=0;j<n-i;j++){
                System.out.print("   ");
            }

            for(int j=0;j<=i*2;j++){
                System.out.printf(" %d ",i+1);
            }

            System.out.println("\n");

        }

    }

    public static void palindromicPattern(int n){

        for(int i=0;i<n;i++){

            for(int j=0;j<n-i;j++){
                System.out.print("   ");
            }

            for(int j=i;j>=0;j--){
                System.out.printf(" %d ",j+1);
            }

            for(int j=1;j<=i;j++){
                System.out.printf(" %d ",j+1);
            }

            System.out.println(" ");

        }

    }

    public static void diamondPattern(int n){

        for(int i=0;i<n;i++){

            for(int j=0;j<n-i;j++){
                System.out.print("   ");
            }

            for(int j=0;j<(i*2)+1;j++){
                System.out.print(" * ");
            }

            System.out.println(" ");

        }

        for(int i=0;i<n;i++){

            for(int j=0;j<=i+1;j++){
                System.out.print("   ");
            }

            for(int j=0;j<((n-i-1)*2)-1;j++){
                System.out.print(" * ");
            }

            System.out.println(" ");

        }

    }



}
