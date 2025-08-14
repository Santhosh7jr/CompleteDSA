package DataStructures.Heaps;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> list;

    public Heap(){

        this.list = new ArrayList<>();

    }

    private void swap(int first,int second){

        T temp = list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);

    }

    private int parent(int idx){
        return (idx-1)/2;
    }

    private int leftChild(int idx){
        return idx*2+1;
    }

    private int rightChild(int idx){
        return idx*2+2;
    }

    public void insert(T value){
        list.add(value);

        upHeap(list.size()-1);
    }

    private void upHeap(int idx){

        if(idx==0) return;

        int pidx = parent(idx);

        if (list.get(pidx).compareTo(list.get(idx))>0){
            swap(idx,pidx);
            upHeap(pidx);
        }

    }

    public T remove() throws Exception {

        if (list.isEmpty()) throw new Exception("There is nothing to Remove");

        T temp = list.getFirst();

        T last = list.removeLast();

        if (!list.isEmpty()){
            list.set(0,last);
            downHeap(0);
        }

        return temp;

    }

    private void downHeap(int idx){

        int min = idx;
        int left = leftChild(idx);
        int right = rightChild(idx);

        if (left<list.size() && list.get(min).compareTo(list.get(left))>0) min = left;
        if (right<list.size() && list.get(min).compareTo(list.get(right))>0) min = right;

        if (min != idx){
            swap(min,idx);
            downHeap(min);
        }

    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> list1 = new ArrayList<>();

        while (!list.isEmpty()){
            list1.add(this.remove());
        }

        return list1;
    }

}
