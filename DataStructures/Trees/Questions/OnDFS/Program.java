package DataStructures.Trees.Questions.OnDFS;

import DataStructures.Trees.BinarySearchTrees.TreeNode;
import DataStructures.Trees.BinarySearchTrees.Main;
import com.sun.source.tree.Tree;

import java.util.*;

public class Program {

    public static void main(String[] args) {

        Main main = new Main();

        main.populateSorted(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});

        System.out.println(main.balanced());

        int[] result = new int[1];

        System.out.println(getDiameter(main.getRoot(), result));
        System.out.println(result[0]);

    }

    //LeetCode - 543 --> Diameter of Binary Tree
    public static int getDiameter(TreeNode root, int[] result) {

        if (root == null) return 0;

        int leftHeight = getDiameter(root.left, result);
        int rightHeight = getDiameter(root.right, result);

        result[0] = Math.max(result[0], leftHeight + rightHeight + 1);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    //LeetCode - 226 Invert Binary Tree
    public static TreeNode invertTree(TreeNode root) {

        if (root == null) return root;

        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);

        root.left = rightNode;
        root.right = leftNode;

        return root;

    }

    //LeetCode - 104 Maximum Depth of Binary Tree
    public static int maxDepth(TreeNode root) {

        if (root == null) return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    //LeetCode - 108 Convert Sorted Array to Binary Search Tree
    public static TreeNode sortedArrayToBST(int[] nums) {

        return getBST(nums, null, 0, nums.length - 1);

    }

    private static TreeNode getBST(int[] nums, TreeNode root, int start, int end) {

        if ((start < 0) || (start > end) || (end >= nums.length)) return root;

        int mid = (start + end) / 2;

        root = new TreeNode(nums[mid]);

        root.left = getBST(nums, root.left, start, mid - 1);
        root.right = getBST(nums, root.right, mid + 1, end);

        return root;

    }

    //LeetCode - 114 Flatten Binary Tree to Linked List
    public static void flatten(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        getNodes(root, list);

        TreeNode node = root;

        for (int i = 1; i < list.size(); i++) {

            node.left = null;
            node.right = new TreeNode(list.get(i));
            node = node.right;

        }

    }

    private static void getNodes(TreeNode root, List<Integer> list) {

        if (root == null) return;

        list.add(root.val);

        getNodes(root.left, list);
        getNodes(root.right, list);

    }

    //LeetCode - 98 Validate Binary Search Tree
    public static boolean isValidBST(TreeNode root) {
        return getResult(root, null, null);
    }

    private static boolean getResult(TreeNode root, Integer lesser, Integer greater) {

        if (root == null) return true;

        if (lesser != null && root.val >= lesser) return false;
        if (greater != null && root.val <= greater) return false;

        boolean left = getResult(root.left, root.val, greater);
        boolean right = getResult(root.right, lesser, root.val);

        return left && right;

    }

    //LeetCode - 236 Lowest Common Ancestor of a Binary Tree
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return root;

    }

}
