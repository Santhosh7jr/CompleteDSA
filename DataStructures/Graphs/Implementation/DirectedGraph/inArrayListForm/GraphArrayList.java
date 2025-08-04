package DataStructures.Graphs.Implementation.DirectedGraph.inArrayListForm;
import java.util.*;

public class GraphArrayList{
    private ArrayList<ArrayList<Integer>> graph;

    public GraphArrayList(int size){
        this.graph=new ArrayList<>(size+1);

        for (int i = 0; i <= size; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public ArrayList<ArrayList<Integer>> getGraph(){
        return this.graph;
    }

    public void insertIntoGraph(HashMap<Integer,List<Integer>> map){

        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){

            int idx=entry.getKey();
            List<Integer> list=entry.getValue();

            for (Integer integer : list) {

                graph.get(idx).add(integer);

            }

        }

    }

    public void printGraph(){

        for(ArrayList<Integer> list: graph){

            System.out.println(list);

        }

    }

}