package Oop.Video5.lambdaFunctions;

interface A1 {
    void function();
//    void function(String str);
}

@FunctionalInterface
interface A2 {
    void function(int num);
}

interface A3 {
    int function(int num);
}

class B implements A1{

    public void function() {
        System.out.println("hey bro, what's up!");
    }

    public void function(String str) {
        System.out.println(str);
    }

}

public class Main {

    public static void main(String[] args) {

        A1 obj = new B();
        obj.function();

        display(obj);

        A1 obj2 = () -> System.out.println("hello!");
        display(obj2);

        A2 obj3 = (num) -> System.out.println(num & 1);
        display(obj3);

        A3 obj4 = (num) -> num;
        System.out.println(display(obj4));

    }

    static void display(A1 obj) {
        obj.function();
    }

    static void display(A2 obj) {
        obj.function(5);
    }

    static int display(A3 obj) {
        return obj.function(10);
    }

}
