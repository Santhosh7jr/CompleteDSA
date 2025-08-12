package DataStructures.LinkedLists.Questions;

import DataStructures.LinkedLists.SinglyLinkedList.*;
import java.util.*;

public class Main<T extends Comparable<T>> {

    public static void main(String[] args) throws Exception {

        DataStructures.LinkedLists.SinglyLinkedList.Main<Integer> linkedList1 = new DataStructures.LinkedLists.SinglyLinkedList.Main<>();
        DataStructures.LinkedLists.SinglyLinkedList.Main<Integer> linkedList2 = new DataStructures.LinkedLists.SinglyLinkedList.Main<>();
        DataStructures.LinkedLists.SinglyLinkedList.Main<Integer> linkedList3 = new DataStructures.LinkedLists.SinglyLinkedList.Main<>();
        Main<Integer> main = new Main<>();

        linkedList1.insertAtBeginning(new ArrayList<>(Arrays.asList(10,20,30,40,50,60)));
        linkedList2.insertAtBeginning(new ArrayList<>(Arrays.asList(10,20,30,40,50)));

        System.out.println(linkedList1.printNodes());
        linkedList3.head = main.rotateRight(linkedList1.head,2);
        System.out.println(linkedList3.printNodes());

    }

    //Q1: insert a value into linked list using recursion.
    public ListNode<T> insertUsingRecursion(ListNode<T> head,T val){

        if (head==null){
            return new ListNode<>(val);

        }

        head.next = insertUsingRecursion(head.next,val);
        return head;

    }

    //Q2: (LeetCode - 83) Remove Duplicates from Sorted List
    public void removeDuplicates(ListNode<T> head){

        if (head==null) return;

        ListNode<T> node = head;

        while (node!=null){

            if (node.next!=null && node.val==node.next.val){
                node.next=node.next.next;
            }else {
                node=node.next;
            }
        }

    }

    //Q3: (LeetCode - 21) Merge Two Sorted Lists
    public ListNode<T> mergeTwoLists(ListNode<T> list1,ListNode<T> list2){

        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode<T> node1 = list1;
        ListNode<T> node2 = list2;

        ListNode<T> temp = new ListNode<>();
        ListNode<T> traverse = temp;

        while (node1!=null && node2!=null){

            if (node1.val.compareTo(node2.val) < 0){
                traverse.next=node1;
                traverse=traverse.next;
                node1=node1.next;
            }else {
                traverse.next=node2;
                traverse=traverse.next;
                node2=node2.next;
            }

        }

        traverse.next = (node1!=null) ? node1 : node2 ;

        return temp.next;
    }

    //Q4; (LeetCode - 141) Linked List Cycle
    public boolean hasCycle(ListNode<T> node){

        ListNode<T> slow = node;
        ListNode<T> fast = node;

        while (fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;

            if (slow==fast){
                return true;
            }

        }

        return false;

    }

    //Q5: find cycle length
    public int findCycleLength(ListNode<T> node){

        ListNode<T> slow = node;
        ListNode<T> fast = node;

        while (fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;

            if (slow==fast){
                break;
            }


        }

        if(fast==null || fast.next==null) return 0;

        ListNode<T> temp = fast.next;
        int count=0;

        while (temp!=fast){
            count++;
            temp=temp.next;
        }

        return count+1;

    }

    //Q6: (LeetCode - 142) Linked List Cycle II
    public ListNode<T> detectCycle(ListNode<T> head) {

        if(head==null || head.next==null){
            return null;
        }

        HashSet<ListNode<T>> set = new HashSet<>();

        ListNode<T> temp=head;

        while(!set.contains(temp) && temp!=null){
            set.add(temp);
            temp=temp.next;
        }

        return temp;

    }

    //Q7: (LeetCode - 202) Happy Number
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();

        while(n!=1){
            if(set.contains(n)) return false;
            set.add(n);
            n=getSquareSum(n);
        }
        return true;
    }

    public static int getSquareSum(int n){
        int sum=0;

        while(n!=0){
            sum+=(n%10)*(n%10);
            n=n/10;
        }
        return sum;
    }

    //Q8: (LeetCode - 876) Middle of the Linked List
    public ListNode<T> middleNode(ListNode<T> head){

        if (head==null) return null;

        ListNode<T> slow = head;
        ListNode<T> fast = head;

        while (fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;

        }

        return slow;

    }

    //Q8 with modifications
    public ListNode<T> middleNode2(ListNode<T> head){

        if (head==null) return null;

        ListNode<T> slow = head;
        ListNode<T> prev = null;
        ListNode<T> fast = head;

        while (fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;

        }
        if (prev!=null) prev.next=null;
        return slow;

    }

    //Q9: (LeetCode - 148) Sort List
    public ListNode<T> mergeSort(ListNode<T> node){

        if (node==null || node.next==null) return node;

        ListNode<T> mid = middleNode2(node);
        ListNode<T> left = mergeSort(node);
        ListNode<T> right = mergeSort(mid);

        return mergeTwoLists(left,right);

    }

    //Q10: reverse linked list
    public ListNode<T> reverseList(ListNode<T> node){

        if (node==null || node.next==null) return node;

        ListNode<T> curr=node;
        ListNode<T> prev=null;

        while (curr!=null){
            ListNode<T> temp = curr.next;

            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        node=prev;
        return node;
    }

    //Q11 (LeetCode - 92) Reverse Linked List II
    public ListNode<T> reverseBetween(ListNode<T> head, int left, int right){

        if(head==null || head.next==null) return head;

        ListNode<T> node = head;
        ListNode<T> prev=null;

        for(int i=0;i<left-1;i++){
            prev=node;
            node=node.next;
        }

        if (node==null || node.next==null) return head;

        ListNode<T> node1 = node;
        ListNode<T> node2 = node.next;
        ListNode<T> next = node2.next;

        for (int i=0;i<right-left;i++){

            node2.next=node1;
            node1=node2;
            node2=next;

            if (node2!=null) next=node2.next;
        }
        if (prev!=null){
            prev.next=node1;
            node.next=node2;
            return head;
        }
        else {
            head.next=node2;
            head=node1;
            return head;

        }

    }

    //Q12: (LeetCode - 234) Palindrome Linked List
    public boolean isPalindrome(ListNode<T> head){

        if (head.next==null) return true;

        if(head.next.next==null){
            if(head.val==head.next.val) return true;
            else return false;
        }

        ListNode<T> slow=head;
        ListNode<T> fast=head;
        ListNode<T> prev=null;

        while (fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next=null;
        fast=reverseList(slow);
        slow=head;

        while (slow!=null && fast!=null){

            if (slow.val!=fast.val) return false;

            slow=slow.next;
            fast=fast.next;

        }

        return true;

    }

    //Q13: (LeetCode - 143) Reorder List
    public ListNode<T> reorderList(ListNode<T> head) {
        if(head==null || head.next==null || head.next.next==null) return head;

        ListNode<T> slow = head;
        ListNode<T> fast = head;
        ListNode<T> prev = null;

        while(fast!=null && fast.next!=null){

            prev=slow;
            slow=slow.next;
            fast=fast.next.next;

        }

        prev.next=null;
        fast=reverseList(slow);

        ListNode<T> leftPart = head;
        ListNode<T> rightPart = fast;

        while(leftPart!=null && rightPart!=null){

            ListNode<T> temp=leftPart.next;
            leftPart.next=rightPart;
            leftPart=temp;

            temp=rightPart.next;
            if(leftPart!=null) rightPart.next=leftPart;
            rightPart=temp;

        }

        return head;

    }

    //Q14: (LeetCode - 61) Rotate List
    public ListNode<T> rotateRight(ListNode<T> head, int k) {
        if (k < 1 || head == null || head.next == null) {
            return head;
        }

        int size=1;
        ListNode<T> temp=head;

        while(temp.next!=null){
            size++;
            temp=temp.next;
        }
        temp.next=head;

        int rotations=k%size;
        int skip=size-rotations;

        ListNode<T> node=head;

        for(int i=0;i<skip-1;i++){
            node=node.next;
        }
        head=node.next;
        node.next=null;

        return head;

    }
}
