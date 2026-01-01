package Greedy.JobSequencing;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] profits = {35, 30, 25, 20, 15, 12, 5};
        int[] deadlines = {3, 4, 4, 2, 3, 1, 2};

        sortJobs(profits, deadlines);

        System.out.println("Maximum Profit: " + findMaximumProfit(profits, deadlines));

    }

    public static void sortJobs(int[] profits, int[] deadlines) {

        for (int i = 0; i < profits.length - 1; i++) {
            for (int j = i; j < profits.length - 1; j++) {
                if (profits[j] < profits[j + 1]) {
                    int temp = profits[j];
                    profits[j] = profits[j + 1];
                    profits[j + 1] = temp;
                }
            }
        }

    }

    public static int findMaximumProfit(int[] profits, int[] deadlines) {

        int count = 0;
        int highestDeadline = getMaximumDeadline(deadlines);

        int[] jobAssignArray = new int[highestDeadline + 1];

        for (int i = 0; i < profits.length; i++) {

            if (assignJob(jobAssignArray, profits[i], deadlines[i])) count++;

            if (count == highestDeadline) break;

        }

        return getTotalProfit(jobAssignArray);

    }

    private static int getTotalProfit(int[] arr) {

        int maxProfit = 0;

        for (int profit : arr) maxProfit += profit;

        return maxProfit;

    }

    private static boolean assignJob(int[] arr, int profit, int deadline) {

        boolean isAssigned = false;

        for (int i = deadline; i > 0; i--) {
            if (arr[i] == 0) {
                isAssigned = true;
                arr[i] = profit;
                break;
            }
        }

        return isAssigned;

    }

    private static int getMaximumDeadline(int[] deadlines) {

        int max = deadlines[0];

        for (int deadline : deadlines) {
            if (deadline > max) max = deadline;
        }

        return max;

    }

}
