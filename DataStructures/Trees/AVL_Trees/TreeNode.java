package DataStructures.Trees.AVL_Trees;

public class TreeNode<T> {

    T val;
    int height;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode() {

    }

    public TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
