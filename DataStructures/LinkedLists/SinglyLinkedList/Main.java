package DataStructures.LinkedLists.SinglyLinkedList;
import java.util.*;

public class Main<T> {

    public ListNode<T> head=null;

    public static void main(String[] args) throws Exception {

        Main<String> main = new Main<>();

        main.insertAtBeginning(new ArrayList<>(Arrays.asList("A","B","D")));
        main.insertAtEnd(new ArrayList<>(Arrays.asList("C","E","F")));

        System.out.println(main.printNodes());

        System.out.println("size: "+main.getSize());

        System.out.println("removed element from the beginning: "+main.deleteFromBeginning());
        System.out.println("removed element from the end: "+main.deleteFromEnd());

        System.out.println(main.printNodes());

        main.reverseList();
        System.out.println("linked list after reversal: "+main.printNodes());

        main.clearList();
        System.out.println("linked list after clearing all nodes: "+main.printNodes());

    }

    public void insertAtBeginning(List<T> list) throws Exception{

        if(list.isEmpty()) throw new Exception("there is nothing to insert");

        if (this.head==null) head=new ListNode<>();

        ListNode<T> temp=this.head;

        for(int i=0;i<list.size();i++){

            if(i==list.size()-1){
                temp.val=list.get(i);
                return;
            }

            temp.val=list.get(i);
            temp.next=new ListNode<T>();
            temp=temp.next;

        }

    }

    public void insertAtEnd(List<T> list)throws Exception{

        if(list.isEmpty()) throw new Exception("there is nothing to insert");
        ListNode<T> temp;

        if (this.head==null) head=new ListNode<>();

        if(this.head.next==null){

            this.head.next=new ListNode<>();
            temp=head.next;

        }else {

            ListNode<T> temp2=this.head;

            while (temp2.next!=null){
                temp2=temp2.next;
            }

            temp2.next=new ListNode<>();
            temp=temp2.next;

        }

        for(int i=0;i<list.size();i++){

            if(i==list.size()-1){
                temp.val=list.get(i);
                return;
            }

            temp.val=list.get(i);
            temp.next=new ListNode<T>();
            temp=temp.next;

        }

    }

    public T deleteFromBeginning() throws Exception{

        if(this.head==null) throw new Exception("there is nothing to remove");

        ListNode<T> node=this.head;
        this.head=this.head.next;

        return (T) node.val;

    }

    public T deleteFromEnd() throws Exception{

        if(this.head==null) throw new Exception("there is nothing to remove");

        ListNode<T> node=this.head;
        ListNode<T> prev=null;

        if(this.head.next==null){
            this.head=null;
            return (T) node.val;
        }

        while (node.next!=null){

            prev=node;
            node=node.next;

        }

        prev.next=null;
        return (T) node.val;

    }

    public int getSize(){

        if(this.head==null) return 0;

        ListNode<T> node=this.head;
        int count=0;

        while (node!=null){
            count++;
            node=node.next;
        }

        return count;

    }

    public List<T> printNodes(){

        List<T> result = new ArrayList<>();

        if(this.head==null) return result;

        ListNode<T> node=this.head;

        while (node!=null){
            result.add((T) node.val);
            node=node.next;
        }

        return result;

    }

    public void reverseList(){

        if(this.head==null || this.head.next==null) return;

        ListNode<T> prev=null;
        ListNode<T> node=this.head;

        while (node!=null){

            ListNode<T> temp=node.next;

            node.next=prev;
            prev=node;
            node=temp;

        }

        this.head=prev;
    }

    public void clearList(){
        this.head=null;
    }

}
