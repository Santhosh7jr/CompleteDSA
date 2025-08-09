package Oop.Video7.CollectionFrameworks;
import java.util.*;

public class Dequeues {

    public static void main(String[] args) {

        Deque<Integer> dq1 = new ArrayDeque<>();  // Faster, resizable array-backed
        Deque<Integer> dq2 = new LinkedList<>();  // Doubly-linked list backed

        dq1.offerFirst(10);
        dq1.offerFirst(20);
        dq1.offerLast(30);
        dq1.offerLast(40);
        System.out.println(dq1);

        dq1.addFirst(5);
        dq1.addLast(55);
        System.out.println(dq1);

        dq1.pollFirst();
        dq1.pollLast();
        System.out.println(dq1);

        dq1.removeFirst();
        dq1.removeLast();
        System.out.println(dq1);

        System.out.println(dq1.peekFirst());
        System.out.println(dq1.peekLast());

        System.out.println(dq1.isEmpty());
        System.out.println(dq1.size());

    }

}
