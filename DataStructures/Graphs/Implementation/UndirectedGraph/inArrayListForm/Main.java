package DataStructures.Graphs.Implementation.UndirectedGraph.inArrayListForm;

import java.util.*;

class GraphArrayList{
    private ArrayList<ArrayList<Integer>> graph;

    public GraphArrayList(int size){
        this.graph=new ArrayList<>(size+1);

        for (int i = 0; i <= size; i++) {
            graph.add(new ArrayList<>());
        }
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

public class Main {

    public static void main(String[] args) {

        HashMap<Integer,List<Integer>> map=new HashMap<>();

        map.put(1,new ArrayList<>(Arrays.asList(2,3)));
        map.put(2,new ArrayList<>(Arrays.asList(1,3,5)));
        map.put(3,new ArrayList<>(Arrays.asList(1,4)));
        map.put(4,new ArrayList<>(Arrays.asList(2,3,5)));
        map.put(5,new ArrayList<>(Arrays.asList(2,4)));

        GraphArrayList graphArrayList=new GraphArrayList(5);
        graphArrayList.insertIntoGraph(map);
        graphArrayList.printGraph();

    }

}
