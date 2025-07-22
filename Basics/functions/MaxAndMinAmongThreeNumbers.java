import java.util.Scanner;

public class MaxAndMinAmongThreeNumbers {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the first number: ");
        int num1=scanner.nextInt();

        System.out.print("enter the second number: ");
        int num2=scanner.nextInt();

        System.out.print("enter the third number: ");
        int num3=scanner.nextInt();

        scanner.close();
        if(num1==num2 && num1==num3){
            System.out.println("\nthe three numbers are equal");
        }else{
            System.out.println("greatest among three numbers is: "+getGreatest(num1,num2,num3));
    
            System.out.println("smallest among three numbers is: "+getSmallest(num1,num2,num3));
        }
    }

    public static int getGreatest(int n1,int n2,int n3){
        if(n1>n2 && n1>n3){
            return n1;
        }else if(n2>n1 && n2>n3){
            return n2;
        }else{
            return n3;
        }
    }

    public static int getSmallest(int n1,int n2,int n3){
        if(n1<n2 && n1<n3){
            return n1;
        }else if(n2<n1 && n2<n3){
            return n2;
        }else{
            return n3;
        }
    }
}