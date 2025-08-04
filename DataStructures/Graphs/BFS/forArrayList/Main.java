package DataStructures.Graphs.BFS.forArrayList;
import DataStructures.Graphs.Implementation.DirectedGraph.inArrayListForm.GraphArrayList;
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

        GraphArrayList graphArrayList=new GraphArrayList(5);
        graphArrayList.insertIntoGraph(map);

        System.out.println(bfs(graphArrayList.getGraph()));


    }

    public static List<Integer> bfs(ArrayList<ArrayList<Integer>> graph){

        boolean visited[]=new boolean[graph.size()];
        List<Integer> list=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();

        queue.add(0);

        while (!queue.isEmpty()){

            Integer node=queue.poll();

            if(!visited[node]){
                visited[node]=true;
                list.add(node);

                for(int i=0;i<graph.get(node).size();i++){
                    queue.offer(graph.get(node).get(i));
                }
            }

        }
        return list;
    }

}
