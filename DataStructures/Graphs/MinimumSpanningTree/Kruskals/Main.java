package DataStructures.Graphs.MinimumSpanningTree.Kruskals;
import java.util.*;

public class Main{

    public static class GraphNode {

        int u;
        int v;
        int w;

        public GraphNode(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

    }

    public static void main(String[] args) {

        int[][] graph = {
                {0, 1, 2, 0, 0, 0, 0},
                {1, 0, 2, 2, 0, 0, 0},
                {2, 2, 0, 0, 3, 0, 4},
                {0, 2, 0, 0, 3, 1, 0},
                {0, 0, 3, 3, 0, 1, 1},
                {0, 0, 0, 1, 1, 0, 2},
                {0, 0, 4, 0, 1, 2, 0}
        };
        List<GraphNode> graphNodeList = new ArrayList<>();
        List<GraphNode> minimumSpanningTree = new ArrayList<>();
        int[] size = new int[graph.length];
        int[] parent = new int[graph.length];

        Arrays.fill(size, 1);
        for (int i = 0; i < graph.length; i++) parent[i] = i;

        fillGraphList(graph, graphNodeList);

        System.out.println("sorted order of graph nodes: ");
        for (GraphNode node : graphNodeList) System.out.println("(edge u - " + node.u + ") ---> (edge v - " + node.v + ") :: (weight w - " + node.w + ")");

        System.out.println("\n" + Arrays.toString(size));
        System.out.println(Arrays.toString(parent));

        System.out.println("\nMST weight: " + createDSU(size, parent, graphNodeList, minimumSpanningTree) + "\n");

        System.out.println(Arrays.toString(size));
        System.out.println(Arrays.toString(parent));

        System.out.println("\nminimum spanning tree: ");
        for (GraphNode node : minimumSpanningTree) System.out.println("(edge u - " + node.u + ") ---> (edge v - " + node.v + ") :: (weight w - " + node.w + ")");

    }

    private static int getParent(int[] parent, int u) {

        if (parent[u] == u) return u;
        return parent[u] = getParent(parent, parent[u]);

    }

    public static int createDSU(int[] size, int[] parent, List<GraphNode> graphNodeList, List<GraphNode> mst) {

        int spanningTreeSize = 0;

        for (GraphNode node : graphNodeList) {

            int u = node.u;
            int v = node.v;
            int w = node.w;

            int uParent = getParent(parent, u);
            int vParent = getParent(parent, v);

            if (uParent == vParent) continue;

            spanningTreeSize += w;
            mst.add(node);

            if (size[uParent] < size[vParent]) {

                parent[uParent] = vParent;
                size[vParent] = size[uParent] + size[vParent];

            } else {

                parent[vParent] = uParent;
                size[uParent] = size[uParent] + size[vParent];

            }

        }

        return spanningTreeSize;

    }

    public static void fillGraphList(int[][] graph, List<GraphNode> graphNodeList) {

        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph.length; j++) {
                if (graph[i][j] != 0) insert(i, j, graph[i][j], graphNodeList);
            }
        }

    }

    private static void insert(int u, int v, int w, List<GraphNode> graphNodeList) {

        GraphNode graphNode = new GraphNode(u, v, w);
        int index = 0;

        if (graphNodeList.isEmpty()) {
            graphNodeList.add(graphNode);
            return;
        }

        for (int i = 0; i < graphNodeList.size(); i++) {
            if (graphNodeList.get(i).w > w) {
                index = i;
                break;
            }
        }

        if (index == 0) {
            graphNodeList.add(graphNode);
            return;
        }

        for (int i = index; i < graphNodeList.size(); i++) {

            GraphNode tempNode = graphNodeList.get(i);
            graphNodeList.set(i, graphNode);
            graphNode = tempNode;

        }

        graphNodeList.add(graphNode);

    }

}
