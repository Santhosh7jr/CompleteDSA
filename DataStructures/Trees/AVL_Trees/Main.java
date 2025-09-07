package DataStructures.Trees.AVL_Trees;

import DataStructures.Trees.AVL_Trees.TreeNode;
import DataStructures.Trees.AVL_Trees.PrettyPrint;
import com.sun.source.tree.Tree;

import java.util.*;

public class Main<T extends Comparable<T>> {

    private TreeNode<T> root;

    public TreeNode<T> getRoot() {
        return root;
    }

    public static void main(String[] args) {

        Main<Integer> main = new Main<>();
        PrettyPrint<Integer> prettyPrint = new PrettyPrint<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(4,2,6,3,5));

        for (Integer i : list) main.insert(i);

        prettyPrint.prettyPrint(main.bfs(main.getRoot()));

    }

    public void insert(T val) {

        this.root = insert(this.root, val);

    }

    private TreeNode<T> insert(TreeNode<T> root, T val) {

        if (root == null) {
            root = new TreeNode<>(val);
            return root;
        }

        if (val.compareTo(root.val) < 0) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return balanced(root);
    }

    private TreeNode<T> balanced(TreeNode<T> root) {

        if (height(root.left) - height(root.right) > 1) {

            if (height(root.left.left) > height(root.left.right)) {
                root = rightRotate(root);
            } else {
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }

        }

        if (height(root.left) - height(root.right) < -1) {

            if (height(root.right.right) > height(root.right.left)) {
                root = leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }

        }

        return root;

    }

    private TreeNode<T> rightRotate(TreeNode<T> root) {

        TreeNode<T> leftChild = root.left;
        TreeNode<T> grandChild = root.left.right;

        leftChild.right = root;
        root.left = grandChild;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        leftChild.height = Math.max(height(leftChild.left), height(leftChild.right)) + 1;

        return leftChild;

    }

    private TreeNode<T> leftRotate(TreeNode<T> root) {

        TreeNode<T> rightChild = root.right;
        TreeNode<T> grandChild = root.right.left;

        rightChild.left = root;
        root.right = grandChild;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        rightChild.height = Math.max(height(rightChild.left), height(rightChild.right)) + 1;

        return rightChild;

    }

    private int height(TreeNode<T> root) {

        if (root == null) return -1;

        return root.height;

    }

    public List<List<T>> bfs(TreeNode<T> root) {

        List<List<T>> list = new ArrayList<>();
        Queue<TreeNode<T>> queue = new LinkedList<>();

        if (root == null) return list;

        queue.offer(root);

        while (! queue.isEmpty()) {

            int size = queue.size();
            List<T> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode<T> node = queue.poll();

                if (node == null) {

                    queue.offer(null);
                    queue.offer(null);
                    temp.add(null);

                    continue;

                }

                queue.offer(node.left);
                queue.offer(node.right);

                temp.add(node.val);

            }

            boolean flag = false;

            for (T val : temp) {

                if (val != null) {
                    flag = true;
                    break;
                }

            }

            if (flag) list.add(temp);
            else return list;

        }

        return list;

    }

}
