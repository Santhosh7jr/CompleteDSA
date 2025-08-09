package Oop.Video7.CollectionFrameworks;
import java.util.*;

public class PriorityQueues {

    public static void main(String[] args) {

        // Min-Heap (default) — smallest element has highest priority
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        // Max-Heap — largest element has highest priority
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        minPQ.offer(10);
        minPQ.offer(20);
        minPQ.offer(30);
        minPQ.offer(40);
        System.out.println(minPQ);

        minPQ.add(50);
        minPQ.add(60);
        System.out.println(minPQ);

        minPQ.poll();
        minPQ.poll();
        System.out.println(minPQ);

        minPQ.remove(10);
        System.out.println(minPQ);

        System.out.println(minPQ.peek());

        System.out.println(minPQ.contains(20));

        System.out.println(minPQ.size());

        System.out.println(minPQ.isEmpty());



    }

}
