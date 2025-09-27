package DataStructures.Graphs.CycleDetection.Directed.UsingBFS;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1,4)));
        list.add(new ArrayList<>(Arrays.asList(2,3)));
        list.add(new ArrayList<>());
        list.add(new ArrayList<>(Arrays.asList(2)));
        list.add(new ArrayList<>(Arrays.asList(3)));

        System.out.println(detectCycle(list));

    }

    public static boolean detectCycle(List<List<Integer>> list) {

        int[] freqTable = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int idx = 0; idx < list.size(); idx++) {
            for (int node : list.get(idx)) {
                freqTable[node]++;
            }
        }

        for (int idx = 0; idx < freqTable.length; idx++) {
            if (freqTable[idx] == 0) stack.push(idx);
        }

        while (! stack.isEmpty()) {

            int node = stack.pop();
            result.add(node);

            for (int num : list.get(node)) {

                freqTable[num]--;
                if (freqTable[num] == 0) stack.push(num);

            }

            if (result.size() != list.size() && stack.isEmpty()) return true;

        }

        return false;

    }

}
