import java.util.Scanner;

public class AreaAndCircumference {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the radius: ");
        double radius=scanner.nextDouble();

        scanner.close();

        System.out.println("\nthe circumference of the circle is: "+circumference(radius));

        System.out.println("the area of the circle is: "+area(radius));
    }

    public static double circumference(double radius){
        return 2*Math.PI*radius;
    }

    public static double area(double radius){
        return Math.PI*radius*radius;
    }

}
