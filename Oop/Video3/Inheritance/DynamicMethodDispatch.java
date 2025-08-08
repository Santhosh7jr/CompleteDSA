package Oop.Video3.Inheritance;

public class DynamicMethodDispatch {

    public static void main(String[] args) {

        ConstructorOverloading constructorOverloading = new SingleInheritance(4,3,5,2);
        System.out.println(constructorOverloading.height);
        System.out.println(constructorOverloading.length);
        System.out.println(constructorOverloading.width);
//        System.out.println(constructorOverloading.weight); <-- not possible

//        SingleInheritance singleInheritance = new ConstructorOverloading(4); <-- not possible

    }

}
