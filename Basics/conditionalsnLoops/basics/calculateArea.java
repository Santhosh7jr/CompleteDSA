import java.util.*;

public class calculateArea {

    public static double circleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double triangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    public static double rectangleArea(double base, double height) {
        return base * height;
    }

    public static double equilateralTriangleArea(double side) {
        return (Math.sqrt(3) / 4) * Math.pow(side, 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println(
                "Enter 1->circleArea \n 2->triangleArea \n 3->rectangleArea \n 4->IsoscelesTriangleArea \n 5->parallelogramArea \n 6->rhombusArea \n 7->equilateralTriangleArea");
                int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter the radius: ");
                double radius = scanner.nextDouble();
                System.out.println("The area of the circle is: " + circleArea(radius));
            } else if (choice == 2) {
                System.out.println("Enter the base and height of the triangle: ");
                double base = scanner.nextDouble();                double height = scanner.nextDouble();
                System.out.println("The area of the triangle is: " + triangleArea(base, height));
            } else if (choice == 3) {
                System.out.println("Enter the base and height of the rectangle: ");
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                System.out.println("The area of the rectangle is: " + rectangleArea(base, height));
            } else if (choice == 4) {
                System.out.println("Enter the base and height of the isosceles triangle: ");
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                System.out.println("The area of the isosceles triangle is: " + triangleArea(base, height));
            } else if (choice == 5) {
                System.out.println("Enter the base and height of the parallelogram: ");
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                System.out.println("The area of the parallelogram is: " + rectangleArea(base, height));
            } else if (choice == 6) {
                System.out.println("Enter the base and height of the rhombus: ");
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                System.out.println("The area of the rhombus is: " + rectangleArea(base, height));
            } else if (choice == 7) {
                System.out.println("Enter the side of the equilateral triangle: ");
                double side = scanner.nextDouble();
                System.out.println("The area of the equilateral triangle is: " + equilateralTriangleArea(side));
            } else {
                System.out.println("Invalid choice");
                break;
            }
        }
        scanner.close();
    }
}
