package Oop.Video2;
import java.util.*;

class Singleton{

    int num;

    private Singleton(int num){
        this.num=num;
    }

    private static Singleton Instance;

    public static Singleton getInstance(){

        if(Instance==null){
            Instance=new Singleton(10);
        }

        return Instance;

    }

}

public class SingletonClass {

    public static void main(String[] args) {

        Singleton singleton1=Singleton.getInstance();
        System.out.println(singleton1.num);

        Singleton singleton2=Singleton.getInstance();
        System.out.println(singleton2.num);

        //both variables singleton1 and singleton2 are pointing to the same object

    }

}
