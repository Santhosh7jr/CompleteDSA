import java.util.*;

public class calculateVolume {
    public static double coneVolume(double radius,double height) {
        return (Math.PI * radius*radius*height)/3;
    }

    public static double prismVolume(double length, double width,double height) {
        return length*width*height;
    }

    public static double cylinderVolume(double radius, double height) {
        return (Math.PI*radius*radius*height);
    }

    public static double sphereVolume(double radius) {
        return 4/3*(Math.PI*radius*radius*radius);
    }

    public static double pyramidVolume(double length, double width,double height) {
        return 1/3*(length*width*height);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println(
                "Enter 1->coneVolume \n 2->prismVolume \n 3->cylinderVolume \n 4->sphereVolume \n 5->pyramidVolume: ");
                int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter the radius and height: ");
                double radius = scanner.nextDouble();
                double height = scanner.nextDouble();
                System.out.println("The volume of the cone is: " + coneVolume(radius,height));
            } else if (choice == 2) {
                System.out.println("Enter the length and height width of the prism: ");
                double length = scanner.nextDouble();
                double height = scanner.nextDouble();
                double width = scanner.nextDouble();
                System.out.println("The volume of the prism is: " + prismVolume(length,width,height));
            } else if (choice == 3) {
                System.out.println("Enter the radius and height of the cylinder: ");
                double radius = scanner.nextDouble();
                double height = scanner.nextDouble();
                System.out.println("The volume of the cylinder is: " + cylinderVolume(radius, height));
            } else if (choice == 4) {
                System.out.println("Enter the radius of the sphere: ");
                double radius = scanner.nextDouble();
                System.out.println("The volume of the sphere is: " + sphereVolume(radius));
            } else if (choice == 5) {
                System.out.println("Enter the length width and height of the pyramid: ");
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();
                double height = scanner.nextDouble();
                System.out.println("The volume of the pyramid is: " + pyramidVolume(length, width, height));
            } else {
                System.out.println("Invalid choice");
                break;
            }
        }
        scanner.close();
    }
}
