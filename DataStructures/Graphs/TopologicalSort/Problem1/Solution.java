package DataStructures.Graphs.TopologicalSort.Problem1;
import java.util.*;

// (LeetCode - 802) Find Eventual Safe States
public class Solution {

    public static void main(String[] args) {

        System.out.println(eventualSafeNodes(new int[][] {{1,2,3,4},{1,2},{3,4},{0,4},{}}));

    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {

        List<List<Integer>> list = new ArrayList<>();
        int size = graph.length;
        int[] inDegree = new int[size];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] tempResult = new boolean[size];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < size; i++) {
            for (int node : graph[i]) {
                list.get(node).add(i);
            }
        }

        for (List<Integer> nodes : list) {
            for (int node : nodes) {
                inDegree[node]++;
            }
        }

        for (int i = 0; i < size; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while(! queue.isEmpty()) {

            int node = queue.poll();
            tempResult[node] = true;

            for (int num : list.get(node)) {
                inDegree[num]--;
                if (inDegree[num] == 0) queue.offer(num);
            }

        }

        for (int i = 0; i < size; i++) {
            if(tempResult[i]) result.add(i);
        }

        return result;

    }
}