package DynamicProgramming.Knapsack.Variations.TargetSum;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] arr = {0,0,0,0,0,0,0,0,1};
        int target = 1;
        int sum = getSum(arr);

        int requiredSum = (sum + target) / 2;

        if ((Math.abs(target) > sum) || ((sum + target) % 2 == 1)) {
            System.out.println("No Target Sum exists");
        } else {

            int[][] dp = new int[arr.length + 1][requiredSum + 1];

            for (int[] row : dp) Arrays.fill(row, -1);

            System.out.println(getSumUsingRecursion(arr, target, 0, 0));
            System.out.println(getSumUsingMemoization(arr, requiredSum, 0, dp));

        }

    }

    public static int getSum(int[] arr) {

        int sum = 0;

        for (int num : arr) sum += num;

        return sum;

    }


    public static int getSumUsingRecursion(int[] arr, int target, int idx, int sum) {


        if (idx == arr.length) return (sum == target) ? 1 : 0;

        int add = getSumUsingRecursion(arr, target, idx + 1, sum + arr[idx]);
        int subtract = getSumUsingRecursion(arr, target, idx + 1, sum - arr[idx]);

        return add + subtract;

    }

    public static int getSumUsingMemoization(int[] arr, int target, int idx, int[][] dp) {

        if (dp[idx][target] != -1) return dp[idx][target];
        if (idx == arr.length) return (target == 0) ? 1 : 0;

        int include = 0;

        if (target >= arr[idx]) include = getSumUsingMemoization(arr, target - arr[idx], idx + 1,  dp);

        int notInclude = getSumUsingMemoization(arr, target, idx + 1, dp);

        return dp[idx][target] = include + notInclude;

    }

}
