package DataStructures.Trees.TraversalMethods;

import DataStructures.Trees.BinarySearchTrees.TreeNode;

import java.util.List;

public class InOrder {

    public static List<Integer> traverse(TreeNode root, List<Integer> list){

        if (root==null) return list;

        traverse(root.left,list);

        list.add(root.getVal());

        traverse(root.right,list);

        return list;

    }

}
