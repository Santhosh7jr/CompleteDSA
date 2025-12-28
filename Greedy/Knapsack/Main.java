package Greedy.Knapsack;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] profits = {20, 5, 10, 40, 15, 25};
        int[] weights = {1, 2,  3,  8,  7,  4};
        int maximumCapacity = 10;

        double[] x = getProfitPerWeight(profits, weights);

        sortArraysBasedOnX(profits, weights, x);

        double[] result = new double[profits.length];

        fillResult(weights, result, maximumCapacity);

        System.out.println(findMaximumPossibleProfit(profits, result));

    }

    public static double[] getProfitPerWeight(int[] profits, int[] weights) {

        double[] x = new double[profits.length];

        for (int i = 0; i < profits.length; i++) {
            x[i] = (double) profits[i] / (double) weights[i];
        }

        return x;

    }

    public static void sortArraysBasedOnX(int[] profits, int[] weights, double[] x) {

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length - 1; j++) {

                if (x[j] < x[j + 1]) {

                    double temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;

                    int temp2 = profits[j];
                    profits[j] = profits[j + 1];
                    profits[j + 1] = temp2;

                    temp2 = weights[j];
                    weights[j] = weights[j + 1];
                    weights[j + 1] = temp2;

                }

            }
        }

    }

    public static void fillResult(int[] weights, double[] result, int capacity) {

        int size = 0;

        for (int i = 0; i < weights.length; i++) {

            if (size == capacity) break;

            if (weights[i] < capacity - size) {
                size += weights[i];
                result[i] = 1;
                continue;
            }

            if (weights[i] > capacity - size) {
                int remaining = capacity - size;
                size += remaining;
                result[i] = remaining / (double) weights[i];
            }

        }

    }

    public static double findMaximumPossibleProfit(int[] profits, double[] result) {

        double possibleProfit = 0;

        for (int i = 0; i < profits.length; i++) possibleProfit += profits[i] * result[i];

        return possibleProfit;

    }

}
