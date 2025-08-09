package Oop.Video7.Enums;

public class Main {

    enum Days{
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday,
        Sunday
    }

    public static void main(String[] args) {

//        Days day = Days.Monday;

        for (Days day : Days.values()){
            System.out.println(day);
        }

    }

}
