package DataStructures.StacksNQueues.Questions;
import java.util.Stack;

//Q1: design queue using stacks
public class MyQueue{

    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueue(){
        this.first=new Stack<>();
        this.second=new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop(){

        if (first.isEmpty()) return -1;

        while (!first.isEmpty()){
            second.push(first.pop());
        }

        int val=second.pop();

        while (!second.isEmpty()){
            first.push(second.pop());
        }

        return val;

    }

    public int peek(){

        if (first.isEmpty()) return -1;

        while (!first.isEmpty()){
            second.push(first.pop());
        }

        int val=second.peek();

        while (!second.isEmpty()){
            first.push(second.pop());
        }

        return val;

    }

    public boolean empty(){
        return first.isEmpty();
    }

}