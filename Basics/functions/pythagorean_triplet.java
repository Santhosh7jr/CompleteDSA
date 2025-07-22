import java.util.*;

public class pythagorean_triplet {

    static boolean triplets(int n1,int n2,int n3){
        if((n1*n1+n2*n2)==n3*n3){
            return true;
        }else if((n2*n2+n3*n3)==n1*n1){
            return true;
        }else if((n3*n3+n1*n1)==n2*n2){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter first number: ");
        int n1=scanner.nextInt();
        System.out.println("enter second number: ");
        int n2=scanner.nextInt();
        System.out.println("enter third number: ");
        int n3=scanner.nextInt();
        scanner.close();

        System.out.println(triplets(n1,n2,n3));
    }

}
