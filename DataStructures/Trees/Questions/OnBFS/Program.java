package DataStructures.Trees.Questions.OnBFS;

import DataStructures.Trees.BinarySearchTrees.TreeNode;
import DataStructures.Trees.BinarySearchTrees.Main;
import com.sun.source.tree.Tree;

import java.util.*;

public class Program extends Main{

    public static void main(String[] args) {}

    //Q1 : (LeetCode - 102) Binary Tree Level Order Traversal.
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }

            result.add(list);

        }

        return result;

    }

    //Q2: (LeetCode - 637) Average of Levels in Binary Tree.
    public static List<Double> averageOfLevels(TreeNode root) {

        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()) {

            int size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }

            list.add(sum/size);

        }

        return list;

    }

    //Q3: Level Order successor of a node
    public static int levelOrderSuccessor(TreeNode root, int target) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node.val == target && ! queue.isEmpty()) return queue.poll().val;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

        }

        return Integer.MIN_VALUE;

    }

    //Q4: (LeetCode - 103) Binary Tree Zigzag Level Order Traversal
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();

        if(root==null) return list;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int size=q.size();

            for(int i=0;i<size;i++){
                TreeNode node=q.poll();

                temp.add(node.val);

                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            list.add(temp);
        }

        for(int i=1;i<list.size();i+=2){
            Collections.reverse(list.get(i));
        }
        return list;
    }

    //Q5: (LeetCode - 107) Binary Tree Level Order Traversal II
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list=new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue=new LinkedList<>();

        if(root==null) return list;

        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> list2=new ArrayList<>();
            int len=queue.size();

            for(int i=0;i<len;i++){
                TreeNode node=queue.poll();

                list2.add(node.val);

                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            stack.push(list2);
        }

        while (! stack.isEmpty()) {
            list.add(stack.pop());
        }

        return list;
    }

    //Q6: (LeetCode - 116) Populating Next Right Pointers in Each Node

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static Node connect(Node root) {

        if (root == null) return root;

        Queue<Node> q=new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){

            int size = q.size();
            Node node = q.poll();

            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);

            for(int i=0;i<size - 1;i++){

                Node node2 = q.poll();

                node.next = node2;
                node = node2;

                if(node2.left!=null) q.offer(node2.left);
                if(node2.right!=null) q.offer(node2.right);

            }
        }

        return root;

    }

    //Q7: (LeetCode - 199) Binary Tree Right Side View
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();

        if(root==null) return list;

        return getAns(list,root);
    }

    private static List<Integer> getAns(List<Integer> list,TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){

            int size=q.size();

            for(int i=0;i<size;i++){
                TreeNode node=q.poll();

                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);

                if(i==size-1) list.add(node.val);
            }
        }
        return list;
    }

    //Q8: (LeetCode - 993) Cousins in Binary Tree
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()) {

            int size = queue.size();
            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < size; i++) {

                boolean left = false;
                boolean right = false;

                TreeNode node = queue.poll();
                set.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                if (node.left != null && (node.left.val == x || node.left.val == y)) left = true;
                if (node.right != null && (node.right.val == y || node.right.val == x)) right = true;

                if (left & right) return false;
                if (set.contains(x) && set.contains(y)) return true;

            }

        }

        return false;

    }

    //Q9: (LeetCode - 101) Symmetric Tree
    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (! queue.isEmpty()) {

            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                if (node == null) {
                    list.add(null);
                    continue;
                }

                list.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);

            }

            for (int left = 0, right = size - 1; left < right; left++, right--) {

                if (!Objects.equals(list.get(left), list.get(right))) return false;

            }

        }

        return true;

    }

}
