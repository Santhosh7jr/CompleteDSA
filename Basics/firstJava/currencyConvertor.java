import java.util.*;;

public class currencyConvertor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter currency in ruppies: ");
        double ruppies = scanner.nextDouble();

        scanner.close();

        double USD=ruppies*0.012;

        System.out.format("indian ruppie RS.%.2f in USD is: %.2f dollars",ruppies,USD);

    }
}
