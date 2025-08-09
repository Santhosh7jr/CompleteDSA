package Oop.Video7.CollectionFrameworks;
import java.util.*;

public class LinkedLists {

    public static void main(String[] args) {

        LinkedList<Integer> list1=new LinkedList<>();
        LinkedList<Integer> list2=new LinkedList<>(Arrays.asList(50,30,40));

        list1.add(10);
        list1.add(1,20);
        System.out.println(list1);

        list1.addFirst(5);
        list1.addLast(25);
        System.out.println(list1);

        list1.addAll(list2);
        System.out.println(list1);

        System.out.println(list1.get(2));

        System.out.println(list1.getFirst());
        System.out.println(list1.getLast());

        System.out.println(list1.size());
        System.out.println(list1.isEmpty());

        list1.set(2,90);
        System.out.println(list1);

        list1.remove(2);
        list1.removeFirst();
        list1.removeLast();
        System.out.println(list1);

        list1.clear();
        System.out.println(list1);

    }

}
