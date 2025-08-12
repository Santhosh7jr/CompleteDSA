package DataStructures.StacksNQueues.Queues;

public class Queue<T> {

    public T val;
    public Queue<T> next;

    public Queue(){
        this.val=null;
        this.next=null;
    }

    public Queue(T val){
        this.val=val;
        this.next=null;
    }

}
