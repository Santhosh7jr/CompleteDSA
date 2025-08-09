package Oop.Video5.AbstractClasses;

public abstract class Parent {

    int age;
    public Parent(int age){
        this.age=age;
    }

    public static void staticMethod(){
        System.out.println("hey!");
    }

    public void instanceMethod(){
        System.out.println("hey, I'm a instance method in abstract class");
    }

    public abstract void career();

}

class Child1 extends Parent{

    public Child1(int age){
        super(age);
    }

    @Override
    public void career() {
        System.out.println("I'm gonna be a Coder!");
    }

}

class Child2 extends Parent{

    public Child2(int age){
        super(age);
    }

    @Override
    public void career() {
        System.out.println("I'm gonna be a Doctor!");
    }

    @Override
    public void instanceMethod(){
        System.out.println("hey, I'm an overridden instance method");
    }

}
