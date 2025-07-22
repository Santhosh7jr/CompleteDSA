import java.util.*;

public class DiscountOfProduct {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter the product actual price: ");
        double price=scanner.nextDouble();

        System.out.print("enter the discount percentage: ");
        double discount=scanner.nextDouble();

        if(discount>100 || discount<0){
            System.out.println("Invalid discount percentage");
        }else{

            System.out.println("\nthe final price of the product is RS. "+(price-(price*discount/100)));
        }
        scanner.close();
    }
}
