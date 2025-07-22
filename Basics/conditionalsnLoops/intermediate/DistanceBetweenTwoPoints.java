import java.util.*;

public class DistanceBetweenTwoPoints {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter  x1: ");
        double x1=scanner.nextDouble();

        System.out.print("enter y1: ");
        double y1=scanner.nextDouble();

        System.out.print("Enter  x2: ");
        double x2=scanner.nextDouble();

        System.out.print("enter y2: ");
        double y2=scanner.nextDouble();

        scanner.close();

        System.out.println("\nthe distance between two points is: "+calculateDistance(x1,y1,x2,y2));

    }

    public static double calculateDistance(double x1,double y1,double x2,double y2){
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }

}
