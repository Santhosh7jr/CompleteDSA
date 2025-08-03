package DataStructures.Graphs.Implementation.UndirectedGraph.inArrayForm;
import java.util.*;

class GraphArray{
    boolean graph[][];

    public GraphArray(int size){
        this.graph=new boolean[size+1][size+1];
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

public class Main {

    public static void main(String[] args) {

        HashMap<Integer,List<Integer>> map=new HashMap<>();

        map.put(1,new ArrayList<>(Arrays.asList(2,3)));
        map.put(2,new ArrayList<>(Arrays.asList(1,3,5)));
        map.put(3,new ArrayList<>(Arrays.asList(1,4)));
        map.put(4,new ArrayList<>(Arrays.asList(2,3,5)));
        map.put(5,new ArrayList<>(Arrays.asList(2,4)));

        GraphArray graphArray=new GraphArray(5);
        graphArray.insertIntoGraph(map);
        graphArray.printGraph();

    }

}
