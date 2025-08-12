package DataStructures.StacksNQueues.Stacks;
import java.util.*;

public class Main<T> {

    private Stack<T> stackHead=null;
    private int stackSize=0;

    public void push(T val){

        Stack<T> node=new Stack<>(val);
        this.stackSize++;

        node.next=this.stackHead;

        this.stackHead=node;

    }

    public T pop() throws Exception{

        if (this.stackHead==null) throw new Exception("Stack is Empty!");

        T val = this.stackHead.val;
        this.stackSize--;

        this.stackHead=this.stackHead.next;

        return val;

    }

    public T peek() throws Exception{

        if (this.stackHead==null) throw new Exception("Stack is Empty!");

        return this.stackHead.val;

    }

    public boolean empty(){
        return this.stackHead==null;
    }

    public int size(){

        return this.stackSize;

    }

    public int search(T object){

        int position=0;

        if (this.stackHead==null) return position;

        Stack<T> node=this.stackHead;

        while (node!=null){

            if(node.val==object) return ++position;

            position++;
            node=node.next;

        }

        return -1;

    }

    public List<T> print(){

        List<T> list = new ArrayList<>();

        Stack<T> stack = this.stackHead;

        while (stack!=null){
            list.add(stack.val);
            stack=stack.next;
        }

        return list;

    }

    public static void main(String[] args) throws Exception {

        Main<Integer> main = new Main<>();

        main.push(10);
        main.push(20);
        main.push(30);
        main.push(40);

        System.out.println(main.print());

        System.out.println(main.pop());

        System.out.println(main.print());

        System.out.println(main.size());

        System.out.println(main.search(20));

        System.out.println(main.peek());

        System.out.println(main.empty());

    }

}
