import java.util.*;

public class armstrong {
    static int isArmstrong(int number,int variable){
        if(number==0){
            return variable;
        }
        int val=number%10;
        variable+=val*val*val;
        return isArmstrong(number/10, variable);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter the number: ");
        int number=scanner.nextInt();
        scanner.close();
        
        int variable=0;
        int Armstrong=isArmstrong(number,variable);
        System.out.println(Armstrong==number);
    }
}
