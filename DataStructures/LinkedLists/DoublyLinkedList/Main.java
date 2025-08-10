package DataStructures.LinkedLists.DoublyLinkedList;
import java.util.*;

public class Main<T> {

    private ListNode<T> head=null;
    private ListNode<T> tail=null;

    public void insert(List<T> list){

        if(this.head==null){
            this.head=new ListNode<>();
        }

        ListNode<T> node=this.head;
        ListNode<T> temp=null;

        for(int i=0;i<list.size();i++){

            if(i==list.size()-1){
                node.val=list.get(i);
                tail.prev=temp;
                break;
            }

            if (tail!=null){
                tail.prev=temp;
            }

            node.val=list.get(i);
            node.next=new ListNode<>();

            temp=node;
            node=node.next;
            this.tail=node;

        }

    }

    public T removeFromFront() throws Exception{

        if (this.head==null) throw new Exception("Linked List is Empty!");

        ListNode<T> node = this.head;

        this.head=this.head.next;
        if(this.head!=null) this.head.prev=null;
        else this.tail=null;

        return node.val;
    }

    public T removeFromEnd() throws Exception{

        if (this.tail==null) throw new Exception("Linked List is Empty!");

        ListNode<T> node = this.tail;

        this.tail=this.tail.prev;
        if(this.tail!=null) this.tail.next=null;
        else this.head=null;

        return node.val;
    }

    public List<T> printFromFront(){
        List<T> list = new ArrayList<>();

        if(this.head==null) return list;

        ListNode<T> node=this.head;

        while (node!=null){
            list.add(node.val);
            node=node.next;
        }

        return list;
    }

    public List<T> printFromEnd(){
        List<T> list = new ArrayList<>();

        if(this.head==null) return list;

        ListNode<T> node=this.tail;

        while (node!=null){
            list.add(node.val);
            node=node.prev;
        }

        return list;
    }

    public static void main(String[] args) throws Exception {

        Main<Integer> main = new Main<>();

        main.insert(new ArrayList<>(Arrays.asList(10,20,30,40,50,60,70)));

        System.out.println(main.removeFromFront());
        System.out.println(main.removeFromFront());
        System.out.println(main.removeFromFront());
        System.out.println(main.removeFromFront());
        System.out.println(main.removeFromFront());
        System.out.println(main.removeFromFront());
        System.out.println(main.removeFromFront());

        System.out.println(main.printFromFront());
        System.out.println(main.printFromEnd());

    }

}
