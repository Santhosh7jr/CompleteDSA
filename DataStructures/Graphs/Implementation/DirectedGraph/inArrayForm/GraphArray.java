package DataStructures.Graphs.Implementation.DirectedGraph.inArrayForm;
import java.util.*;

public class GraphArray{
    boolean graph[][];

    public GraphArray(int size){
        this.graph=new boolean[size+1][size+1];
    }

    public boolean[][] getGraph(){
        return this.graph;
    }

    public void insertIntoGraph(HashMap<Integer,List<Integer>> map){

        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){

            int idx=entry.getKey();
            List<Integer> list=entry.getValue();

            for (Integer integer : list) {

                graph[idx][integer] = true;
                graph[integer][idx]=true;

            }

        }

    }

    public void printGraph(){

        for(boolean arr[] : graph){

            System.out.println(Arrays.toString(arr));

        }

    }

}
