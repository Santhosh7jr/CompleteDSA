package DataStructures.Stacks;

public class Stack<T> {

    T val;
    Stack<T> next;

    public Stack(){
        this.val=null;
        this.next=null;
    }

    public Stack(T val){
        this.val=val;
        this.next=null;
    }

}
