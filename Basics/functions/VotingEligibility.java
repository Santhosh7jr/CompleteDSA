import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter your age: ");
        int age=scanner.nextInt();

        scanner.close();

        if(isEligible(age)){
            System.out.println("\nyes, the candidate is eligible to vote!");
        }else{
            System.out.println("\nno,you can't vote. you are a child!");
        }
    }

    public static boolean isEligible(int n){
        if(n>=18){
            return true;
        }else{
            return false;
        }
    }
}
