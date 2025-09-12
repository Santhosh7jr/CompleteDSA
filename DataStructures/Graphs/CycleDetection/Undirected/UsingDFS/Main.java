package DataStructures.Graphs.CycleDetection.Undirected.UsingDFS;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>(Arrays.asList(1,2)));
        list.add(new ArrayList<>(Arrays.asList(0,3)));
        list.add(new ArrayList<>(Arrays.asList(0,4)));
        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(2)));

        System.out.println(isCycle(list));

    }

    public static boolean isCycle(List<List<Integer>> graph) {

        boolean[] visited = new boolean[graph.size()];

        for (int i = 0; i < visited.length; i++){

            if (!visited[i]) {

                if (checkForCycle(i, -1, graph, visited)) return true;

            }

        }

        return false;

    }

    private static boolean checkForCycle(int node, int parent, List<List<Integer>> graph, boolean[] visited) {

        visited[node]=true;

        for (Integer neighbour : graph.get(node)) {

            if (!visited[neighbour]) {

                checkForCycle(neighbour, node, graph, visited);

            } else if (parent != neighbour) {

                return true;

            }

        }

        return false;

    }

}
