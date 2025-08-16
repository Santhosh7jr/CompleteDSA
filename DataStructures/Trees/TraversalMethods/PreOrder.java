package DataStructures.Trees.TraversalMethods;
import DataStructures.Trees.BinarySearchTrees.TreeNode;

import java.util.List;

public class PreOrder {

    public static List<Integer> traverse(TreeNode root,List<Integer> list){

        if (root==null) return list;

        list.add(root.getVal());

        traverse(root.left,list);
        traverse(root.right,list);

        return list;

    }

}
