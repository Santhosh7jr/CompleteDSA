package DynamicProgramming.MatrixChainMultiplication.Implementation;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] matrixDimensions = {40, 20, 30, 10, 30};

        System.out.println(getMinimumNumberOfMultiplicationsRequired(matrixDimensions, 1, matrixDimensions.length - 1));

    }

    public static int getMinimumNumberOfMultiplicationsRequired(int[] arr, int left, int right) {

        if (left >= right) return 0;

        int min = Integer.MAX_VALUE;

        for (int i = left; i < right; i++) {
            min = Math.min(min,
                    (
                        getMinimumNumberOfMultiplicationsRequired(arr, left, i) +
                        getMinimumNumberOfMultiplicationsRequired(arr, i + 1, right) +
                        (arr[left - 1] * arr[i] * arr[right])
                    ));
        }

        return min;

    }

}
