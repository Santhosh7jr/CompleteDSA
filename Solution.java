import java.util. * ;
import java.io. *;

public class Solution {
    public static void main(String[] args) {

        System.out.println(isCyclicRotation(new long[] {1, 2, 3, 1}, new long[] {1, 1, 2, 3}, 4));

    }

    public static boolean isCyclicRotation(long[] arr1, long[] arr2, int n) {

        long target = arr1[0];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr2[i] == target) {
                list.add(i);
            }
        }

        for (int num : list) {

            int idx = num;
            int index = 0;
            boolean flag = true;

            for (int i = idx; i < n; i++) {
                if (arr2[i] != arr1[index++]) {
                    flag = false;
                    break;
                }
            }

            for (int i = 0; i < idx; i++) {
                if (arr2[i] != arr1[index++]) {
                    flag = false;
                    break;
                }
            }

            if (flag) return flag;

        }

        return false;

    }

}