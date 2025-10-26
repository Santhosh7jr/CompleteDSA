package DataStructures.Graphs.FloydWarshall;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[][] graph = {{0,1,2}, {0,5,3},{1,3,3}, {1,5,-1}, {2,5,2}, {3,2,1}, {4,0,2}, {4,2,2}, {5,1,1}, {5,3,-2}, {5,4,1}};
        int vertices = 6;

        for (int[] distances : floydWarshall(graph, vertices)) {
            System.out.println(Arrays.toString(distances));
        }

    }

    public static int[][] floydWarshall(int[][] graph, int n) {

        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);

        for (int[] nodes : graph) distance[nodes[0]][nodes[1]] = nodes[2];
        for (int i =0; i < n; i++) distance[i][i] = 0;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }

        return distance;

    }

}
