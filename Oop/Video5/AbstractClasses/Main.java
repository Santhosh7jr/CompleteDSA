package Oop.Video5.AbstractClasses;

public class Main {

    public static void main(String[] args) {

        Child1 child1=new Child1(40);
        child1.career();
        child1.instanceMethod();
        System.out.println(child1.age);

        Child2 child2=new Child2(40);
        child2.career();
        child2.instanceMethod();
        System.out.println(child2.age);


//        Parent parent = new Parent(); <-- it is not possible to create the object of an abstract class.
        Parent.staticMethod();

    }

}
