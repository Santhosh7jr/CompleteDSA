package DataStructures.Graphs.BFS.forArray;
import DataStructures.Graphs.Implementation.DirectedGraph.inArrayForm.GraphArray;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer,List<Integer>> map=new HashMap<>();

        map.put(0,new ArrayList<>(Arrays.asList(3,5)));
        map.put(1,new ArrayList<>(Arrays.asList(2)));
        map.put(2,new ArrayList<>(Arrays.asList()));
        map.put(3,new ArrayList<>(Arrays.asList(1,4)));
        map.put(4,new ArrayList<>(Arrays.asList(2)));
        map.put(5,new ArrayList<>(Arrays.asList(2)));

        GraphArray graphArray=new GraphArray(5);
        graphArray.insertIntoGraph(map);

        System.out.println(bfs(graphArray.getGraph()));

    }

    public static List<Integer> bfs(boolean[][] graph){

        boolean visited[]=new boolean[graph.length];
        List<Integer> list=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();

        queue.offer(0);

        while (!queue.isEmpty()){

            Integer node=queue.poll();

            if(!visited[node]){

                visited[node]=true;
                list.add(node);

                for(int i=0;i<graph[node].length;i++){

                    if(graph[node][i]){

                        queue.offer(i);

                    }

                }
            }

        }

        return list;

    }

}
