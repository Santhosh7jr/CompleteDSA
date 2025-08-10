package DataStructures.LinkedLists.CircularLinkedList;
import java.util.*;

public class Main<T> {

    ListNode<T> head=null;

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
                temp.next=this.head;
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

        if(this.head.next==this.head){

            this.head.next=new ListNode<>();
            temp=head.next;

        }else {

            ListNode<T> temp2=this.head;

            while (temp2.next!=this.head){
                temp2=temp2.next;
            }

            temp2.next=new ListNode<>();
            temp=temp2.next;

        }

        for(int i=0;i<list.size();i++){

            if(i==list.size()-1){
                temp.val=list.get(i);
                temp.next=this.head;
                return;
            }

            temp.val=list.get(i);
            temp.next=new ListNode<T>();
            temp=temp.next;

        }

    }

    public T deleteFromBeginning() throws Exception{

        if(this.head==null) throw new Exception("there is nothing to remove");

        ListNode<T> delNode=this.head;
        ListNode<T> node=this.head;

        if(this.head.next==this.head) {
            this.head=null;
            return (T) node.val;
        }

        while (node.next!=this.head){
            node=node.next;
        }

        this.head=this.head.next;
        node.next=head;

        return (T) delNode.val;

    }

    public T deleteFromEnd() throws Exception{

        if(this.head==null) throw new Exception("there is nothing to remove");

        ListNode<T> node=this.head;
        ListNode<T> prev=null;

        if(this.head.next==this.head) {
            this.head=null;
            return (T) node.val;
        }

        while (node.next!=this.head){

            prev=node;
            node=node.next;

        }

        prev.next=this.head;
        return (T) node.val;

    }

    public int getSize(){

        if(this.head==null) return 0;

        ListNode<T> node=this.head;
        int count=0;

        while (node.next!=head){
            count++;
            node=node.next;
        }

        return count+1;

    }

    public List<T> printNodes(){

        List<T> result = new ArrayList<>();

        if(this.head==null) return result;

        ListNode<T> node=this.head;

        while (node.next!=head){
            result.add((T) node.val);
            node=node.next;
        }

        result.add((T) node.val);
        return result;

    }

    public void reverseList(){

        if(this.head==null || this.head.next==head) return;

        ListNode<T> lastNode=this.head;
        ListNode<T> prev=null;
        ListNode<T> node=this.head;

        while (node.next!=this.head){

            ListNode<T> temp=node.next;

            node.next=prev;
            prev=node;
            node=temp;

        }
        node.next=prev;
        this.head=node;
        lastNode.next=this.head;
    }

    public void clearList(){
        this.head=null;
    }

}
