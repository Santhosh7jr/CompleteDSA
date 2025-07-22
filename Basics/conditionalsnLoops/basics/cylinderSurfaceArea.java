import java.util.*;

public class cylinderSurfaceArea {
    public static double curvedSurfaceAreaOfCylinder(double radius,double height) {
        return (2*Math.PI * radius*height);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter the radius and height: ");
        double radius = scanner.nextDouble();
        double height = scanner.nextDouble();
        System.out.println("The curved surface area of cylinder is: " + curvedSurfaceAreaOfCylinder(radius, height));
            
        scanner.close();
    }
}
