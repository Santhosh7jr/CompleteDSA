package DataStructures.StacksNQueues.Questions;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*MyQueue myQueue = new MyQueue();

        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());*/

        System.out.println(minCount("())(())(())"));

    }

    //Q2: game of two stacks - hackerRank {Not Optimal}
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {

        return twoStacks(maxSum, a, b,0,0);

    }

    private static int twoStacks(int maxSum, List<Integer> a, List<Integer> b, int sum, int count) {
        if (sum > maxSum) return count - 1;
        if (a.isEmpty() && b.isEmpty()) return count;

        int choiceA = Integer.MIN_VALUE;
        int choiceB = Integer.MIN_VALUE;

        if (!a.isEmpty()) {
            choiceA = twoStacks(maxSum, a.subList(1, a.size()), b, sum + a.get(0), count + 1);
        }
        if (!b.isEmpty()) {
            choiceB = twoStacks(maxSum, a, b.subList(1, b.size()), sum + b.get(0), count + 1);
        }

        return Math.max(choiceA, choiceB);
    }

    //Q3: (LeetCode - 20) Valid parenthesis
    public static boolean isValid(String s){

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if (ch=='[' || ch=='{' || ch=='('){
                stack.push(ch);
            }else {

                if (ch=='}'){
                    if(stack.isEmpty() || stack.pop()!='{') return false;
                }

                if (ch==']'){
                    if(stack.isEmpty() || stack.pop()!='[') return false;
                }

                if (ch==')'){
                    if(stack.isEmpty() || stack.pop()!='(') return false;
                }

            }

        }

        return stack.isEmpty();

    }

    //Q4: (LeetCode - 921) Minimum Add to Make Parentheses Valid
    public static int minAddToMakeValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){

            if(ch=='('){
                stack.push(ch);
            }else{
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }

        }

        return stack.size();

    }

    public static int minCount(String s){

        int count=0;
        Stack<Character> stack = new Stack<>();

        int idx=0;

        while (idx<s.length()){

            if (s.charAt(idx)=='('){
                stack.push(s.charAt(idx));
            }else {

                if (idx==s.length()-1 && !stack.isEmpty()){
                    stack.pop();
                    count++;
                } else if (idx==s.length()-1 && stack.isEmpty()){
                    count+=2;
                } else if (s.charAt(idx+1)==')' && !stack.isEmpty()) {
                    idx++;
                    stack.pop();
                }else if (s.charAt(idx+1)==')' && stack.isEmpty()){
                    count++;
                    idx++;
                } else if (s.charAt(idx+1)!=')' && !stack.isEmpty()) {
                    count++;
                    stack.pop();
                } else {
                    count+=2;
                }

            }

            idx++;

        }

        return count+(stack.size()*2);

    }

}
