package Oop.Video7.CollectionFrameworks;
import java.util.*;

public class ArrayLists {

    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(40,30,50));

        list1.add(10);
        list1.add(1,20);
        System.out.println(list1);

        list1.addAll(list2);
        System.out.println(list1);

        Collections.sort(list1);
        System.out.println(list1);

        Collections.reverse(list1);
        System.out.println(list1);

        System.out.println(list1.get(2));

        System.out.println(list1.size());

        System.out.println(list1.isEmpty());

        list1.remove(1);
        System.out.println(list1);

        System.out.println(list1.contains(20));

        System.out.println(list1.indexOf(50));

        list1.clear();

        System.out.println(list1);

    }

}
