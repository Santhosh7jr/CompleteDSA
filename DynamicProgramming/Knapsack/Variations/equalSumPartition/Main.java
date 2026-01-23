package DynamicProgramming.Knapsack.Variations.equalSumPartition;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(isPossible(new int[] {1, 5, 10, 5}));

    }

    public static boolean isPossible(int[] arr) {

        int sum = 0;

        for (int num : arr) sum += num;

        if (sum % 2 == 1) return false;

        return DynamicProgramming.Knapsack.Variations.SubsetSum.Main.checkIfSubsetExistsUsingBooleanTabulation(arr, sum / 2);

    }

}
