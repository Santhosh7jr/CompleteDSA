package DataStructures.Graphs.ShortestPaths.forUndirectedGraphs;
import java.util.*;

//finding shortest path in undirected graph with unit(distance = 1, between each two nodes) distance.

public class Main {

    public static void main(String[] args) {

        int[][] graph = {{1,2,8}, {0,2,5}, {0,1,3}, {4,2,8}, {3,5,6}, {1,4,6}, {4,5,7,9}, {6},{1,3,9}, {6,8}};
        int source = 0;
        System.out.println(Arrays.toString(findShortestPath(source, graph)));

    }

    public static int[] findShortestPath(int source, int[][] graph) {

        List<List<Integer>> list = new ArrayList<>();
        int[] distance = new int[graph.length];
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.offer(new ArrayList<>(Arrays.asList(source, 0)));
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int[] ints : graph) {

            List<Integer> temp = new ArrayList<>();

            for (int num : ints) {
                temp.add(num);
            }

            list.add(temp);

        }

        while (! queue.isEmpty()) {

            List<Integer> temp = queue.poll();

            int node = temp.get(0);
            int dist = temp.get(1);

            for (int num : list.get(node)) {

                if (distance[num] > dist + 1) {
                    distance[num] = dist + 1;
                    queue.offer(new ArrayList<>(Arrays.asList(num, dist + 1)));
                }

            }

        }

        return distance;

    }

}
