package DataStructures.LinkedLists.DoublyLinkedList;

public class ListNode<T> {

    T val;
    ListNode<T> next;
    ListNode<T> prev;

    public ListNode(){
        this.val=null;
        this.next=null;
        this.prev=null;
    }

    public ListNode(T val){
        this.val=val;
        this.next=null;
        this.prev=null;
    }

}
