import java.util.*;

public class calculatePerimeter {
    
    public static double circlePerimeter(double radius) {
        return 2*Math.PI * radius;
    }

    public static double trianglePerimeter(double side1, double side2,double side3) {
        return side1+side2+side3;
    }

    public static double rectanglePerimeter(double base, double height) {
        return (2*base)+(2* height);
    }

    public static double squarePerimeter(double side) {
        return 4*side;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println(
                "Enter 1->circlePerimeter \n 2->trianglePerimeter \n 3->rectanglePerimeter \n 4->parallelogramPerimeter \n 5->ghombusPerimeter \n 6->squarePerimeter: ");
                int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter the radius: ");
                double radius = scanner.nextDouble();
                System.out.println("The Perimeter of the circle is: " + circlePerimeter(radius));
            } else if (choice == 2) {
                System.out.println("Enter the three sides of the triangle: ");
                double side1 = scanner.nextDouble();
                double side2 = scanner.nextDouble();
                double side3 = scanner.nextDouble();
                System.out.println("The Perimeter of the triangle is: " + trianglePerimeter(side1,side2,side3));
            } else if (choice == 3) {
                System.out.println("Enter the base and height of the rectangle: ");
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                System.out.println("The Perimeter of the rectangle is: " + rectanglePerimeter(base, height));
            } else if (choice == 4) {
                System.out.println("Enter the base and height of the parallelogram: ");
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                System.out.println("The Perimeter of the parallelogram is: " + rectanglePerimeter(base, height));
            } else if (choice == 5) {
                System.out.println("Enter the base and side length of the rhombus: ");
                double side = scanner.nextDouble();
                System.out.println("The Perimeter of the rhombus is: " + squarePerimeter(side));
            } else if (choice == 6) {
                System.out.println("Enter the side length of the square: ");
                double side = scanner.nextDouble();
                System.out.println("The Perimeter of the equilateral square is: " + squarePerimeter(side));
            } else {
                System.out.println("Invalid choice");
                break;
            }
        }
        scanner.close();
    }

}
