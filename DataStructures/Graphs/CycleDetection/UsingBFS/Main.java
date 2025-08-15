package DataStructures.Graphs.CycleDetection.UsingBFS;
import java.util.*;

public class Main {

    public static boolean isCycle(List<List<Integer>> graph){

        boolean visited[] = new boolean[graph.size()];

        for (int i = 0; i < visited.length; i++){

            if (!visited[i]){

                if(checkForCycle(i,graph,visited)) return true;

            }

        }

        return false;

    }

    public static boolean checkForCycle(int i, List<List<Integer>> graph,boolean[] visited){

        visited[i] = true;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i,-1});

        while (!q.isEmpty()){

            int[] node = q.poll();

            for (int neighbour : graph.get(node[0])){

                if (!visited[neighbour]){

                    visited[neighbour] = true;
                    q.offer(new int[] {neighbour,node[0]});

                } else if (neighbour != node[1]) {

                    return true;

                }

            }

        }

        return false;

    }

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>(Arrays.asList(1,2)));
        list.add(new ArrayList<>(Arrays.asList(0,2,3)));
        list.add(new ArrayList<>(Arrays.asList(0,1,3,4)));
        list.add(new ArrayList<>(Arrays.asList(1,2)));
        list.add(new ArrayList<>(Arrays.asList(2)));

        System.out.println(isCycle(list));

    }

}
