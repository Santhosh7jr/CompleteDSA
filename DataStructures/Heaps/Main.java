package DataStructures.Heaps;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Heap<Integer> heap = new Heap<>();

        for( int num : new int[] {5,7,9,8,11,12,14,13,10}){
            heap.insert(num);
        }

        System.out.println(heap.heapSort());

    }

}
