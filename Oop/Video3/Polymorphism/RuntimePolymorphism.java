package Oop.Video3.Polymorphism;
import java.util.*;

public class RuntimePolymorphism {

    public void method(){
        System.out.println("this is a function");
    }

    public int method(int n){
        return (int) Math.pow(n,2);
    }

    public double method(double n){
        return Math.pow(n,3);
    }

    public int method(int m,int n){
        return m+n;
    }

    public String method(String str,double d){
        return str+" "+(int) d;
    }

}
