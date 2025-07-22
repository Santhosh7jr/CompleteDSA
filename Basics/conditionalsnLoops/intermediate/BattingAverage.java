import java.util.*;

public class BattingAverage {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter the player name: ");
        String name = scanner.nextLine();

        System.out.print("enter total runs scored : ");
        int score=scanner.nextInt();

        System.out.print("enter total times out: ");
        int out=scanner.nextInt();

        scanner.close();

        System.out.println("\nbatting average of "+name+" is "+(double)score/out);
    }
}
