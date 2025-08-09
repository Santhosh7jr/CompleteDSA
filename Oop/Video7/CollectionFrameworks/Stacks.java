package Oop.Video7.CollectionFrameworks;
import java.util.*;

public class Stacks {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack);

        stack.pop();
        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack.empty());
        System.out.println(stack.size());

        System.out.println(stack.search(20));



    }

}
