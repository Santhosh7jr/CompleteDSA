package Oop.Video2;
import java.util.*;

class Main1{

    int num;

    public Main1(int num){
        this.num=num;
    }

}

public class NestedClasses {

    public static class Main2{

        int num;

        public Main2(int num){
            this.num=num;
        }

    }

    public class Main3{

        int num;

        public Main3(int num){
            this.num=num;
        }

    }

    public static void main(String[] args) {

        Main1 main1=new Main1(10); // Independent and class
        System.out.println(main1.num);

        Main2 main2=new Main2(20); // Inner static class
        System.out.println(main2.num);

        NestedClasses nestedClasses=new NestedClasses();
        NestedClasses.Main3 main3=nestedClasses.new Main3(30); // Inner non-static class
        System.out.println(main3.num);

    }

}
