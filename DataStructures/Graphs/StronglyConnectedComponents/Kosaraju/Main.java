package DataStructures.Graphs.StronglyConnectedComponents.Kosaraju;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[][] graph = {
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        List<List<List<Integer>>> graphList = new ArrayList<>();
        boolean[] visitedForGraphList = new boolean[graph.length];
        Stack<Integer> stackForGraphList = new Stack<>();

        List<List<List<Integer>>> reversedGraphList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) reversedGraphList.add(new ArrayList<>());
        boolean[] visitedForReversedGraphList = new boolean[graph.length];

        int sccCount = 0;
        List<String> sccNodes = new ArrayList<>();

        constructGraphList(graph, graphList, reversedGraphList);

        for (int i = 0; i < graphList.size(); i++) {
            if (! visitedForGraphList[i]) traverseGraph(i, graphList, visitedForGraphList, stackForGraphList);
        }

        for (int i = 0; i < reversedGraphList.size(); i++) {
            if (! visitedForReversedGraphList[i]) {
                sccNodes.add(traverseGraph(i, reversedGraphList, visitedForReversedGraphList,"[ ") + "]");
                sccCount++;
            }
        }

        System.out.println(graphList);
        System.out.println(reversedGraphList);
        System.out.println(stackForGraphList);
        System.out.println(sccCount);
        System.out.println(sccNodes);

    }

    public static String traverseGraph(int i, List<List<List<Integer>>> graphList, boolean[] visited, String path) {

        if (visited[i]) return path;

        path += i + " ";

        visited[i] = true;

        if (graphList.get(i).isEmpty()) return path;

        for (List<Integer> node : graphList.get(i)) {
            path = traverseGraph(node.get(1), graphList, visited, path);
        }

        return path;

    }

    public static void traverseGraph(int i, List<List<List<Integer>>> graphList, boolean[] visited, Stack<Integer> stack) {

        if (visited[i]) return;

        visited[i] = true;

        for (List<Integer> node : graphList.get(i)) traverseGraph(node.get(1), graphList, visited, stack);

        stack.push(i);

    }

    public static void constructGraphList(int[][] graph, List<List<List<Integer>>> graphList, List<List<List<Integer>>> reversedGraphList) {

        for (int i = 0; i < graph.length; i++) {

            List<List<Integer>> graphListNode = new ArrayList<>();

            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    graphListNode.add(Arrays.asList(i, j));
                    reversedGraphList.get(j).add(Arrays.asList(j, i));
                }
            }

            graphList.add(graphListNode);

        }

    }

}
