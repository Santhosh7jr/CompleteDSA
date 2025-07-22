import java.util.*;

public class NCRandNPR {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter total number of items: ");
        int numberOfItems = scanner.nextInt();

        System.out.print("enter total number of selected items: ");
        int numberOfSelectedItems = scanner.nextInt();

        scanner.close();

        int numberOfItemsFactorial=1;

        int numberOfSelectedItemsFactorial=1;

        for(int i=1;i<=numberOfItems;i++){
            numberOfItemsFactorial*=i;
        }

        for(int i=1;i<=numberOfSelectedItems;i++){
            numberOfSelectedItemsFactorial*=i;
        }



        System.out.println("\nthe NCR is: "+(numberOfItemsFactorial/(numberOfItemsFactorial-numberOfSelectedItemsFactorial)));

        System.out.println("\nthe NPR is: "+(numberOfItemsFactorial/(numberOfSelectedItemsFactorial)*(numberOfItemsFactorial-numberOfSelectedItemsFactorial)));
    }

}
