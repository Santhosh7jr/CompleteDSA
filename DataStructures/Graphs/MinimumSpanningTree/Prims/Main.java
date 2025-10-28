package DataStructures.Graphs.MinimumSpanningTree.Prims;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[][] graph = {
                {0, 1, 3, 2, 0, 0, 1, 0},
                {1, 0, 0, 1, 1, 1, 0, 0},
                {3, 0, 0, 2, 1, 0, 3, 1},
                {2, 1, 2, 0, 2, 0, 0, 0},
                {0, 1, 1, 2, 0, 2, 0, 1},
                {0, 0, 0, 0, 2, 0, 1, 4},
                {0, 0, 3, 0, 0, 1, 0, 3},
                {0, 0, 1, 0, 1, 4, 3, 0}
        };

        List<List<Integer>> mst = prims(graph);
        int minDist = mst.removeLast().get(0);

        System.out.println("MST: " + mst + "\n" + "Total Minimum distance: " + minDist);

    }

    public static List<List<Integer>> prims(int[][] matrix) {

        int n = matrix.length;
        int count = 0;

        List<List<Integer>> result = new ArrayList<>();
        List<List<int[]>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {

            graph.add(new ArrayList<>());

            for (int j = 0; j < n; j++) {
                if(matrix[i][j] != 0) graph.get(i).add(new int[] {i, j, matrix[i][j]});
            }

        }

        PriorityQueue<List<Integer>> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.get(2), b.get(2)));
        heap.offer(new ArrayList<>(Arrays.asList(-1, 0, 0)));

        while (! heap.isEmpty()) {

            List<Integer> node = heap.poll();

            int x = node.get(0);
            int y = node.get(1);
            int wt = node.get(2);

            if (visited[y]) continue;

            for (int[] nodes : graph.get(y)) {
                heap.offer(new ArrayList<>(Arrays.asList(y, nodes[1], nodes[2])));
            }

            if (x != -1) result.add(new ArrayList<>(Arrays.asList(x, y, wt)));
            visited[y] = true;
            count += wt;

        }

        result.add(new ArrayList<>(List.of(count)));
        return result;

    }

}
