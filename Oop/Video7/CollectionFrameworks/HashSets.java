package Oop.Video7.CollectionFrameworks;
import java.util.*;

public class HashSets {

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(10,20,70,80));

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        System.out.println(set);

        set.addAll(set1);
        System.out.println(set);

        System.out.println(set.contains(10));

        System.out.println(set.remove(20));

        System.out.println(set);

        System.out.println(set.size());

        System.out.println(set.isEmpty());

        set.clear();

        System.out.println(set);

    }

}
