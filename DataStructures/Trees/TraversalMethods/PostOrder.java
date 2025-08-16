package DataStructures.Trees.TraversalMethods;

import DataStructures.Trees.BinarySearchTrees.TreeNode;

import java.util.List;

public class PostOrder {

    public static List<Integer> traverse(TreeNode root, List<Integer> list){

        if (root==null) return list;

        traverse(root.left,list);
        traverse(root.right,list);

        list.add(root.getVal());

        return list;

    }

}
