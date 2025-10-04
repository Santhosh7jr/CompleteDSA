package DataStructures.Graphs.ShortestPaths.forDAGs;
import java.util.*;

class Node {

    int vertex;
    int distance;

    public Node (int vertex, int distance) {

        this.vertex = vertex;
        this.distance = distance;

    }

}

public class Main {

    public static void main(String[] args) {

        List<List<Node>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Arrays.asList(new Node(1,2), new Node(3, 1))));
        graph.add(new ArrayList<>(Arrays.asList(new Node(2,3))));
        graph.add(new ArrayList<>(Arrays.asList(new Node(4,4))));
        graph.add(new ArrayList<>(Arrays.asList(new Node(2,1), new Node(4, 1))));
        graph.add(new ArrayList<>());

        System.out.println(Arrays.toString(findShortestPath(0, graph)));

    }

    public static int[] findShortestPath(int src, List<List<Node>> graph) {

        int size = graph.size();
        boolean[] vis = new boolean[size];
        Stack<Integer> stack = new Stack<>();
        int[] distance = new int[size];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i < size; i++) {
            if (!vis[i]) dfs(i, graph, vis, stack);
        }

        while (!stack.isEmpty()) {

            int val = stack.pop();

            for (Node node : graph.get(val)) {
                distance[node.vertex] = Math.min(distance[node.vertex], distance[val] + node.distance);
            }

        }

        return distance;

    }

    private static void dfs(int vertex, List<List<Node>> graph, boolean[] vis, Stack<Integer> stack) {

        if (vis[vertex]) return;

        vis[vertex] = true;

        for (Node node : graph.get(vertex)) {
            dfs(node.vertex, graph, vis, stack);
        }

        stack.push(vertex);

    }

}
