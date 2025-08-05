package Oop.Video2;
import java.util.*;

public class StaticMethods {

    public final int num=10;
    public static int num2;

    //static block {will run only once when the first object is get created}
    static {
        StaticMethods.num2=20;
    }

    public static void main(String[] args) {

        StaticMethods staticMethods=new StaticMethods();
        staticMethods.fn2(); //non-static method

        fn1(); //static method

        staticMethods.fn4();

    }

    public static void fn1(){
        System.out.println("this is a static function");
//        System.out.println(this.num); <-- throws an error because fn1() is a static function
    }

    public void fn2(){
        System.out.println("this is a not static function");
        System.out.println(this.num); //can call num, because fn2() is a non-static method
    }

    //using non-static function inside static function
    public static void fn3(){
        StaticMethods staticMethods=new StaticMethods();
        staticMethods.fn2();
    }

    //using static method inside a non-static method
    public void fn4(){
        fn3();
    }

}
