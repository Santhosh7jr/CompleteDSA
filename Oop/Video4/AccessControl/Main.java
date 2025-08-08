package Oop.Video4.AccessControl;

public class Main {

    public static void main(String[] args) {

        Encapsulate encapsulate = new Encapsulate();

//        encapsulate.size; <-- not possible
        System.out.println(encapsulate.getSize());
        encapsulate.setSize(20);
        System.out.println(encapsulate.getSize());
    }

}
