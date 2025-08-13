package DataStructures.Graphs.DFS.Problem1;

import DataStructures.Graphs.Implementation.UndirectedGraph.inArrayForm.GraphArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://www.geeksforgeeks.org/problems/number-of-provinces/1 <-- GFG
class Solution {
    public static int numProvinces(boolean[][] adj) {
        boolean visited[]=new boolean[adj.length];
        int count=0;

        for(int i=0;i<visited.length;i++){

            if(!visited[i]){
                count++;
                dfs(i,adj,visited);
            }

        }

        return count;

    }

    public static void dfs(int idx,boolean adj[][],boolean visited[]){

        visited[idx]=true;

        for(int i=0;i<adj[idx].length;i++){
            if(!visited[i] && adj[idx][i]){
                dfs(i,adj,visited);
            }
        }
    }

    public static void main(String[] args) {

        HashMap<Integer, List<Integer>> map1=new HashMap<>();

        map1.put(0,new ArrayList<>(Arrays.asList(0,3)));
        map1.put(1,new ArrayList<>(Arrays.asList(1,2)));
        map1.put(2,new ArrayList<>(Arrays.asList(1,2)));
        map1.put(3,new ArrayList<>(Arrays.asList(0,3)));

        GraphArray testCase1=new GraphArray(3);
        testCase1.insertIntoGraph(map1);


        HashMap<Integer, List<Integer>> map2=new HashMap<>();

        map2.put(0,new ArrayList<>(Arrays.asList(0,2)));
        map2.put(1,new ArrayList<>(Arrays.asList(1)));
        map2.put(2,new ArrayList<>(Arrays.asList(0,2)));

        GraphArray testCase2=new GraphArray(2);
        testCase2.insertIntoGraph(map2);


        System.out.println("testcase1 result: "+numProvinces(testCase1.getGraph()));
        System.out.println("testcase2 result: "+numProvinces(testCase2.getGraph()));
    }

}

