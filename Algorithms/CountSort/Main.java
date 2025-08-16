package Algorithms.CountSort;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(countSort(new int[] {1,2,3,4,2,1,2,3,4,6,5,4,3,2,1,2,4,6,5,4})));

    }

    public static int[] countSort(int[] arr) {

        int maxVal = getMax(arr);
        int count[] = new int[maxVal+1];

        for (int num : arr) {

            count[num] += 1;

        }

        int idx=0;

        for(int i = 0; i < count.length; i++){

            int num = count[i];

            if (num > 0){

                for (int j = 0; j < num; j++) {

                    arr[idx++] = i;

                }

            }

        }

        return arr;

    }

    private static int getMax(int[] arr){

        int max = Integer.MIN_VALUE;

        for (int num : arr) {

            if (num > max) max = num;

        }

        return max;

    }

}
