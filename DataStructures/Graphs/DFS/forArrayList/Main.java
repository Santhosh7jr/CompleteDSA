package DataStructures.Graphs.DFS.forArrayList;
import DataStructures.Graphs.Implementation.DirectedGraph.inArrayListForm.GraphArrayList;

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

        GraphArrayList graphArrayList=new GraphArrayList(5);
        graphArrayList.insertIntoGraph(map);
//        graphArrayList.printGraph();

        System.out.println(dfs(0,graphArrayList.getGraph(),new ArrayList<>(),new boolean[6]));
    }

    public static List<Integer> dfs(int node,ArrayList<ArrayList<Integer>> graph,ArrayList<Integer> result,boolean visited[]){

        result.add(node);
        visited[node]=true;

        for (Integer neighbour : graph.get(node)){
            if (!visited[neighbour]){
                dfs(neighbour,graph,result,visited);
            }
        }

        return result;

    }
    
}
