package Oop.Video6.ExceptionHandling;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int a=5;
        int b=0;

        try{
            throw new MyException("just for fun!");
//            System.out.println(divide(a,b));
        }catch (ArithmeticException arithmeticException){
            System.out.println(arithmeticException.getMessage());
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }finally {
            System.out.println("this will always run!");
        }

//        System.out.println(divide(a,b));

    }

    public static int divide(int a,int b) throws ArithmeticException{
        if (b==0){
            throw new ArithmeticException("DO not divide by zero");
        }

        return a/b;
    }

}
