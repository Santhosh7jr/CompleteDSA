package DataStructures.Graphs.Implementation.UndirectedGraph.inArrayForm;
import java.util.*;

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
