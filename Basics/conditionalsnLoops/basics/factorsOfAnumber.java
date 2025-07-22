import java.util.*;

public class factorsOfAnumber {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter any number: ");
        int n = scanner.nextInt();
        scanner.close();

        printFactors(n);

   } 

   public static void printFactors(int n){

        System.out.print("Factors of "+n+" --> ");
        for(int i=1;i<=n;i++){
            if(n%i==0){
                System.out.print(i+"  ");
            }
        }
   }

}
