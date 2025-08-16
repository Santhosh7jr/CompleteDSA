package DataStructures.Trees.BinarySearchTrees;

public class TreeNode {

    public int val;
    int height;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }

    public int getVal(){
        return this.val;
    }

    public int getHeight() {
        return this.height;
    }
}
