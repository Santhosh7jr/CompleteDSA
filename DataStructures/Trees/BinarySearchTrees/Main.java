package DataStructures.Trees.BinarySearchTrees;

import DataStructures.Trees.TraversalMethods.*;
import java.util.*;

public class Main {

    private TreeNode root=null;

    public TreeNode getRoot(){
        return this.root;
    }

    public int getHeight(TreeNode root){

        if (root==null) return -1;

        return root.getHeight();

    }

    public boolean isEmpty(TreeNode root){
        return root==null;
    }

    private void insert(int val){

        this.root = insert(this.root,val);

    }

    private TreeNode insert(TreeNode root,int val){

        if (root==null) return new TreeNode(val);

        if (root.getVal() > val) root.left = insert(root.left,val);
        else root.right = insert(root.right,val);

        root.height = Math.max(getHeight(root.left),getHeight(root.right))+1;

        return root;

    }

    public void populate(int nums[]){

        for (int num : nums){
            this.insert(num);
        }

    }

    public void populateSorted(int nums[]){

        this.populateSorted(nums,0,nums.length-1);

    }

    private void populateSorted(int nums[],int start,int end){

        if (start>end) return;

        int mid = (start+end)/2;

        this.insert(nums[mid]);

        populateSorted(nums,start,mid-1);

        populateSorted(nums,mid+1,end);

    }

    public boolean balanced(){
        return balanced(this.root);
    }

    private boolean balanced(TreeNode root){

        if (root==null) return true;

        return Math.abs(this.getHeight(root.left) - this.getHeight(root.right)) <= 1 &&
                (balanced(root.left) && balanced(root.right));

    }

    public static void main(String[] args) {

        Main main = new Main();

        main.populate(new int[] {7,4,3,5});

        main.populateSorted(new int[] {7,8,9});

        System.out.println(main.balanced());

        System.out.println("PreOrder Traversal: "+PreOrder.traverse(main.getRoot(),new ArrayList<>()));
        System.out.println("InOrder Traversal: "+InOrder.traverse(main.getRoot(),new ArrayList<>()));
        System.out.println("PostOrder Traversal: "+PostOrder.traverse(main.getRoot(),new ArrayList<>())+"\n");
        PrettyPrint.prettyPrint(main.getRoot());

    }

}
