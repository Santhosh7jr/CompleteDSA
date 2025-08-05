package DataStructures.Graphs.DFS.forArray;
import DataStructures.Graphs.Implementation.DirectedGraph.inArrayForm.GraphArray;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer,List<Integer>> map=new HashMap<>();

        map.put(0,new ArrayList<>(Arrays.asList(2,4)));
        map.put(1,new ArrayList<>(Arrays.asList(0,5)));
        map.put(2,new ArrayList<>(Arrays.asList(5)));
        map.put(3,new ArrayList<>(Arrays.asList(0,1)));
        map.put(4,new ArrayList<>(Arrays.asList(2,3)));
        map.put(5,new ArrayList<>(Arrays.asList(3,4)));

        GraphArray graphArray=new GraphArray(5);
        graphArray.insertIntoGraph(map);
//        graphArray.printGraph();

        System.out.println(dfs(0,graphArray.getGraph(),new ArrayList<>(),new boolean[6]));
    }

    public static List<Integer> dfs(int node,boolean[][] graph,List<Integer> result,boolean[] visited){

        result.add(node);
        visited[node]=true;

        for(int neighbour=0;neighbour<graph[node].length;neighbour++){
            if(graph[node][neighbour] && !visited[neighbour]){
                dfs(neighbour,graph,result,visited);
            }
        }

        return result;

    }

}
