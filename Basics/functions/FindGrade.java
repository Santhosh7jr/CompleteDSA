import java.util.Scanner;

public class FindGrade {
    public static void main(String[] args) {
        
        Scanner scanner=new Scanner(System.in);

        System.out.print("enter your marks in percentge farmat: ");
        double grade=scanner.nextInt();
        scanner.close();

        findGrade(grade);
    }

    public static void findGrade(double grade){
        if(grade>100 || grade<0){
            System.out.println("invalid grade!");
        }else if(grade>90 && grade<=100){
            System.out.println("Grade --> AA");
        }else if(grade>80 && grade<=90){
            System.out.println("Grade --> AB");
        }else if(grade>70 && grade<=80){
            System.out.println("Grade --> BB");
        }else if(grade>60 && grade<=70){
            System.out.println("Grade --> BC");
        }else if(grade>50 && grade<=60){
            System.out.println("Grade --> CC");
        }else if(grade>40 && grade<=50){
            System.out.println("Grade --> CD");
        }else if(grade<=40){
            System.out.println("Grade --> DD");
        }else{
            System.out.println("error");
        }
    }
}
