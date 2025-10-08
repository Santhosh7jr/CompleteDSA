package DataStructures.Graphs.Dijkstra.Algorithm;

import DataStructures.Graphs.Dijkstra.GraphNode.Node;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[][][] graphArr = {{ {1,1}, {2,4}, {5,10}, {6,1} },
                {{0,1}, {2,1}, {6,1} },
                { {0,4}, {1,1}, {3,2}, {4,3}, {5,5}, {6,1} },
                { {2,2}, {4,1}, {5,1} },
                { {2,3}, {3,1}, {6,4} },
                { {0,10}, {2,5}, {3,1}, {6,1} },
                { {0,1}, {1,1}, {2,1}, {4,4}, {5,1} }
        };

        List<List<Node>> graph = new ArrayList<>();
        int source = 0;

        for (int i = 0; i < graphArr.length; i++) {

            graph.add(new ArrayList<>());

            for (int[] node : graphArr[i]) graph.get(i).add(new Node(node[0], node[1]));

        }

        System.out.println(Arrays.toString(dijkstra(source, graph)));

    }

    public static int[] dijkstra(int source, List<List<Node>> graph) {

        int size = graph.size();
        int[] distance = new int[size];
        Arrays.fill(distance, Integer.MAX_VALUE);
        List<Node> heap = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        heap.add(new Node(source, 0));
        distance[source] = 0;

        while (! heap.isEmpty()) {

            Node node = heap.removeFirst();

            if (map.containsKey(node.vertex) && (map.get(node.vertex) <= node.distance)) continue;
            else map.put(node.vertex, node.distance);

            for (Node neighbour : graph.get(node.vertex)) {

                if (distance[neighbour.vertex] > node.distance + neighbour.distance) {

                    distance[neighbour.vertex] = node.distance + neighbour.distance;
                    heap.add(new Node(neighbour.vertex, node.distance + neighbour.distance));
                    heapify(heap.size() - 1, heap);

                }

            }

        }

        return distance;

    }

    private static int getParent(int idx) {
        return (idx - 1) / 2;
    }

    private static void heapify(int idx, List<Node> heap) {

        int parent = getParent(idx);

        if (parent == idx) return;

        if ((heap.get(parent).vertex > heap.get(idx).vertex) || (heap.get(parent).vertex == heap.get(idx).vertex && heap.get(parent).distance > heap.get(idx).distance)) {
            swap(parent, idx, heap);
            heapify(parent, heap);
        }

    }

    private static void swap(int x, int y, List<Node> heap) {
        Node temp = heap.get(x);
        heap.set(x, heap.get(y));
        heap.set(y, temp);
    }

}
