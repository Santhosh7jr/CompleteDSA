package Oop.Video3.Polymorphism;

public class RunTime {

    public void area(){
        System.out.println("this is a area function!");
    }

    public final void method(){
        System.out.println("this method can't be overridden! Because, it is final method");
        System.out.println("and we can't override final methods");
    }

    public static void staticMethod(){
        System.out.println("static methods are also can't be overridden.");
    }

}

class Square extends RunTime{

    @Override
    public void area(){
        System.out.println("area of the square is: a*a");
    }

//    @Override
//    public void method(){} <-- not possible

}

class Rectangle extends RunTime{

    @Override
    public void area(){
        System.out.println("area of the rectangle is: height*width");
    }

//    @Override
//    public static void staticMethod(){} <-- not possible

}

class Circle extends RunTime{

    @Override
    public void area(){
        System.out.println("area of the circle is: pie*r*r");
    }

    public static void staticMethod(){
        System.out.println("this is a static method in circle class");
    }

}
