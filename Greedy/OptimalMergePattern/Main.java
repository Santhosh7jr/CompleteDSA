package Greedy.OptimalMergePattern;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] sizes = {6, 5, 2, 3};

        fillPq(sizes, pq);
        System.out.println(pq);
        System.out.println(getMinMergeCost(pq));

    }

    public static int getMinMergeCost(PriorityQueue<Integer> priorityQueue) {

        if (priorityQueue.isEmpty()) return -1;

        int costSize = 0;

        while (priorityQueue.size() != 1) {

            int sum = priorityQueue.poll() + priorityQueue.poll();

            costSize += sum;

            priorityQueue.offer(sum);

        }

        return costSize;

    }

    public static void fillPq(int[] arr, PriorityQueue<Integer> pq) {
        for (int num : arr) pq.offer(num);
    }

}
