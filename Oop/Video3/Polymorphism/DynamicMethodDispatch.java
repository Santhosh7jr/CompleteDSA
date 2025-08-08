package Oop.Video3.Polymorphism;

public class DynamicMethodDispatch {

    public static void main(String[] args) {

        RunTime runTime = new RunTime();
        runTime.staticMethod();
        runTime.area();

        RunTime runTime1 = new Circle();
        runTime1.staticMethod();
        runTime1.area();

        RunTime runTime2 = new Square();
        runTime2.area();

    }

}
