package DataStructures.Graphs.Dijkstra.Problem1;
import DataStructures.Graphs.Dijkstra.GraphNode.Node;
import java.util.*;

//https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1

public class Solution {

    public static void main(String[] args) {

        int[][][] graphArr = {{ {1,1}, {2,4}, {5,10}, {6,1} },
                {{0,1}, {2,1}, {6,1} },
                { {0,4}, {1,1}, {3,2}, {4,3}, {5,5}, {6,1} },
                { {2,2}, {4,1}, {5,1} },
                { {2,3}, {3,1}, {6,4} },
                { {0,10}, {2,5}, {3,1}, {6,1} },
                { {0,1}, {1,1}, {2,1}, {4,4}, {5,1} }
        };

        int source = 0;
        int destination = 4;
        int initialDistance = 0;

        int[] distanceArray = new int[graphArr.length];
        Arrays.fill(distanceArray, Integer.MAX_VALUE);
        distanceArray[source] = 0;

        List<List<Node>> graph = new ArrayList<>();
        HashMap<String, Integer> pathMap = new HashMap<>();
        HashMap<Integer, Integer> distanceMap = new HashMap<>();


        for (int i = 0; i < graphArr.length; i++) {

            graph.add(new ArrayList<>());

            for (int[] node : graphArr[i]) graph.get(i).add(new Node(node[0], node[1]));

        }

        getShortestPath(source, destination, initialDistance, "" + source, graph, distanceMap, pathMap, distanceArray);

        String path = "";
        int distance = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : pathMap.entrySet()) {
            if (entry.getValue() < distance) {
                distance = entry.getValue();
                path = entry.getKey();
            }
        }

        System.out.format("\nThe shortest path from %d and %d is: \"%s\" with distance: %d\n",source, destination, path, distance);

    }

    public static void getShortestPath(int source, int destination, int distance, String path, List<List<Node>> graph, HashMap<Integer, Integer> distanceMap, HashMap<String, Integer> pathMap, int[] distanceArray) {

        if (source == destination) {
            pathMap.put(path, distance);
            return;
        }

        if (distanceMap.containsKey(source) && (distanceMap.get(source) <= distance)) return;
        else distanceMap.put(source, distance);

        for (Node neighbour : graph.get(source)) {

            int vertex = neighbour.vertex;
            int dist = neighbour.distance;

            if (distanceArray[vertex] > dist + distance) {

                distanceArray[vertex] = dist + distance;
                getShortestPath(vertex, destination, dist + distance, path + " --> " +vertex, graph, distanceMap, pathMap, distanceArray);

            }

        }

    }

}
