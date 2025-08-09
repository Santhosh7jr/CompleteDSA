package Oop.Video7.CollectionFrameworks;
import java.util.*;

public class Queues {

    public static void main(String[] args) {

        Queue<Integer> q1 = new LinkedList<>();  // Linked list backed
        Queue<Integer> q2 = new ArrayDeque<>(); // Faster, no capacity restriction

        q2.offer(10);
        q2.offer(20);
        q2.offer(30);
        q2.offer(40);

        System.out.println(q2);

        q2.add(50);
        q2.add(60);
        System.out.println(q2);

        q2.poll();
        q2.poll();
        System.out.println(q2);

        q2.remove();
        q2.remove();
        System.out.println(q2);

        System.out.println(q2.peek());

        System.out.println(q2.element()); //throws exception if queue is empty

        System.out.println(q2.isEmpty());
        System.out.println(q2.size());



    }

}
