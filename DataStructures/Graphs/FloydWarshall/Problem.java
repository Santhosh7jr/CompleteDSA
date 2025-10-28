package DataStructures.Graphs.FloydWarshall;
import java.util.*;

//(LeetCode - 1334) Find the City With the Smallest Number of Neighbors at a Threshold Distance
public class Problem {

    public static void main(String[] args) {

        System.out.println(findTheCity(4,new int[][] {{0,1,3},{1,2,1},{1,3,4},{2,3,1}}, 4));

    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] graph = new int[n][n];
        int city = Integer.MIN_VALUE;
        int edge = n;

        for (int i = 0; i < n; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }

        for (int[] nodes : edges) {
            graph[nodes[0]][nodes[1]] = nodes[2];
            graph[nodes[1]][nodes[0]] = nodes[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {
                if (graph[i][j] <= distanceThreshold) count++;
            }

            if (count <= edge && i > city) {
                city = i;
                edge = count;
            }

        }

        return city;

    }
}
