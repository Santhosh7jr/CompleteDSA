import java.util.*;

public class cubeSurfaceArea {
    public static double totalSurfaceAreaOfCube(double side) {
        return (6*side);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter the side length: ");
        double side = scanner.nextDouble();
        System.out.println("The curved surface area of cylinder is: " + totalSurfaceAreaOfCube(side));
            
        scanner.close();
    }
}
