import java.util.*;

public class CalculateCGPA {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        System.out.print("enter number of subjects: ");
        int numberOfSubjects=scanner.nextInt();

        double totalMarks=0;
        int i;
        for(i=1;i<=numberOfSubjects;i++){

            System.out.print("Enter "+i+" th subject marks: ");
            double marks=scanner.nextDouble();

            if(marks>100 || marks<0){
                System.out.println("\nI N V A L I D  I N P U T");
                break;
            }
            totalMarks+=marks;
        }

        if(i<numberOfSubjects){
        }else{
            System.out.format("\nthe total CGPA is: %.2f",((totalMarks/numberOfSubjects)/10));
        }
        scanner.close();
    }
}
