package Oop.Video7.CollectionFrameworks;
import java.util.*;

public class HashMaps {

    public static void main(String[] args) {

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(1,10);
        map.put(2,20);
        map.put(3,30);
        System.out.println(map);

        map.putIfAbsent(4,40);
        System.out.println(map);

        System.out.println(map.get(2));

        System.out.println(map.getOrDefault(3,1));

        System.out.println(map.containsKey(2));

        System.out.println(map.containsValue(10));

        map.remove(2);
        System.out.println(map);

        map.replace(3,25);
        System.out.println(map);

        System.out.println(map.size());

        System.out.println(map.isEmpty());

        map.clear();

        System.out.println(map);

    }

}
