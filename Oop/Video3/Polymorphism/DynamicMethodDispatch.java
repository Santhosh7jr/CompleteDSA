package Oop.Video3.Polymorphism;

public class DynamicMethodDispatch {

    public static void main(String[] args) {

        CompileTimePolymorphism compileTimePolymorphism = new CompileTimePolymorphism();
        compileTimePolymorphism.staticMethod();
        compileTimePolymorphism.area();

        CompileTimePolymorphism compileTimePolymorphism1 = new Circle();
        compileTimePolymorphism1.staticMethod();
        compileTimePolymorphism1.area();

        CompileTimePolymorphism compileTimePolymorphism2 = new Square();
        compileTimePolymorphism2.area();

    }

}
