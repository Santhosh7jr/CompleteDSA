public class Dispersion {

    public static double calculateDepreciation(double initialCost, double salvageValue, int usefulLife) {
        return (initialCost - salvageValue) / usefulLife;
    }

    public static void main(String[] args) {
        
        double initialCost = 50000; 
        double salvageValue = 5000;  
        int usefulLife = 5;        

        double annualDepreciation = calculateDepreciation(initialCost, salvageValue, usefulLife);

        System.out.println("Annual Depreciation Cost: " + annualDepreciation);
    }
}
