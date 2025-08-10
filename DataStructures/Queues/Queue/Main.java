package DataStructures.Queues.Queue;
import java.util.*;

public class Main<T> {

    private Queue<T> queueHead=null;
    private int queueSize=0;

    public void offer(T val){

        Queue<T> node = new Queue<>(val);

        if(this.queueHead==null){
            this.queueHead=node;
            this.queueSize++;
            return;
        }

        Queue<T> temp=this.queueHead;
        this.queueSize++;

        while (temp.next!=null){
            temp=temp.next;
        }

        temp.next=node;

    }

    public T poll() throws Exception{

        if (this.queueHead==null) throw new Exception("Queue is Empty!");

        T val = this.queueHead.val;

        this.queueHead=this.queueHead.next;
        this.queueSize--;

        return val;

    }

    public T peek() throws Exception{

        if (this.queueHead==null) throw new Exception("Queue is Empty!");

        return this.queueHead.val;

    }

    public boolean isEmpty(){

        return this.queueHead==null;

    }

    public int size(){

        return this.queueSize;

    }

    public List<T> print(){

        List<T> list = new ArrayList<>();

        if (this.queueHead==null) return list;

        Queue<T> node = this.queueHead;

        while (node!=null){
            list.add(node.val);
            node=node.next;
        }

        return list;
    }

    public static void main(String[] args) throws Exception {

        Main<Integer> main = new Main<>();

        main.offer(10);
        main.offer(20);
        main.offer(30);
        main.offer(40);

        System.out.println(main.print());

        System.out.println(main.poll());

        System.out.println(main.size());

        System.out.println(main.peek());

        System.out.println(main.print());

    }

}
