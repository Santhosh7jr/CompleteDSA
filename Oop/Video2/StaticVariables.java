package Oop.Video2;
import java.util.*;

public class StaticVariables {

    String name;
    int age;
    static long population;

    public StaticVariables(String name,int age){
        this.name=name;
        this.age=age;

        StaticVariables.population++;
    }

    public static void main(String[] args) {

        StaticVariables staticVariables1=new StaticVariables("kunal",25);
        System.out.println(StaticVariables.population);


        StaticVariables staticVariables2=new StaticVariables("rahul",32);
        System.out.println(StaticVariables.population);


        StaticVariables staticVariables3=new StaticVariables("kiran",20);
        System.out.println(StaticVariables.population);

    }

}
