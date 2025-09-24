package DataStructures.Graphs.TopologicalSort.UsingDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1,3)));
        list.add(new ArrayList<>(Arrays.asList(2)));
        list.add(new ArrayList<>(Arrays.asList(4)));
        list.add(new ArrayList<>(Arrays.asList(2,4)));
        list.add(new ArrayList<>());

        System.out.println(topSort(list));

    }

    public static List<Integer> topSort(List<List<Integer>> graph) {

        boolean[] vis = new boolean[graph.size()];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!vis[i]) dfs(i, graph, vis, stack);
        }

        while (!stack.isEmpty()) result.add(stack.pop());

        return result;

    }

    public static void dfs(int i, List<List<Integer>> graph, boolean[] vis, Stack<Integer> stack) {

        if (vis[i]) return;

        vis[i] = true;
        stack.push(i);

        for (int node : graph.get(i)) dfs(node,graph,vis,stack);

    }

}
