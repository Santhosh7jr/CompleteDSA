package DataStructures.Graphs.BellmanFord;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int nodes = 6;
        int[][] graph = {
                {0,1,5},
                {1,2,-2},
                {1,5,-3},
                {2,4,3},
                {3,2,6},
                {3,4,-2},
                {5,3,1}
        };

        System.out.println(Arrays.toString(bellmanFord(nodes, graph, 0)));

    }

    public static int[] bellmanFord(int n, int[][] graph, int source) {

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int i = 1; i < n; i++) {
            for (int[] edge : graph) {
                if (distance[edge[0]] != Integer.MAX_VALUE && distance[edge[0]] + edge[2] < distance[edge[1]]) {
                    distance[edge[1]] = distance[edge[0]] + edge[2];
                }
            }
        }

        //To detect negative cycles
        for (int[] edge : graph) {
            if (distance[edge[0]] != Integer.MAX_VALUE && distance[edge[0]] + edge[2] < distance[edge[1]]) {
                System.out.println("Graph contains a negative weight cycle!");
                break;
            }
        }

        return distance;

    }

}
