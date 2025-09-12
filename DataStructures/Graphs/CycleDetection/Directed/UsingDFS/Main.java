package DataStructures.Graphs.CycleDetection.Directed.UsingDFS;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(isCyclic(4, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 3}}));

    }

    public static boolean isCyclic(int V, int[][] edges) {

        boolean[] gv = new boolean[V];
        boolean[] lv = new boolean[V];
        List<List<Integer>> list = constructList(V, edges);

        for (int i = 0; i < V; i++) {

            if (! gv[i]) {

                if (dfs(i, list, gv, lv)) return true;

            }

        }

        return false;

    }

    private static List<List<Integer>> constructList(int V, int[][] edges) {

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < V; i++) {

            list.add(new ArrayList<>());

        }

        for (int[] edge : edges) list.get(edge[0]).add(edge[1]);

        return list;

    }

    private static boolean dfs(int node, List<List<Integer>> edges, boolean[] gv, boolean[] lv) {

        if (edges.get(node) == null) return false;

        if (lv[node]) return true;

        gv[node] = true;
        lv[node] = true;

        for (int i : edges.get(node)) {

            if (dfs(i, edges, gv, lv)) return true;

        }

        lv[node] = false;
        return false;

    }

}
