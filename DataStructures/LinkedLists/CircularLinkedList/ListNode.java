package DataStructures.LinkedLists.CircularLinkedList;

public class ListNode<T> {

    public T val;
    public ListNode<T> next;

    public ListNode(){
        this.val=null;
        this.next=null;
    }

    public ListNode(T val){
        this.val=val;
    }

}
