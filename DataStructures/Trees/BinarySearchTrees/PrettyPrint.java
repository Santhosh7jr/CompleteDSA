package DataStructures.Trees.BinarySearchTrees;

import java.util.*;

public class PrettyPrint {

    public static void prettyPrint(TreeNode root){

        int height = getHeight(root,0);

        char[][] tree = new char[height+1][(int) (Math.pow(2,height)*2-1)];
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;

        queue.offer(node);

        // Fill with spaces
        for (int i = 0; i < tree.length; i++) {
            Arrays.fill(tree[i], ' ');
        }

        int idx=0;
        int marker = 2;

        while (!queue.isEmpty()){

            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i=0;i<size;i++){

                TreeNode temp = queue.poll();

                if (temp!=null) {
                    list.add(temp.val);
                }
                else {
                    list.add(null);
                    continue;
                }

                if (temp.left!=null) queue.offer(temp.left);
                else queue.offer(null);

                if (temp.right!=null) queue.offer(temp.right);
                else queue.offer(null);

            }

            // Place values in char[][] based on spacing
            int gap = (int) Math.pow(2, height - idx + 1) - 1;
            int start = gap / 2;
            int pos = start;
            for (Integer val : list) {
                if (val != null) {
                    String s = String.valueOf(val);
                    for (int k = 0; k < s.length(); k++) {
                        tree[idx][pos + k] = s.charAt(k);
                    }
                }
                pos += gap + 1;
            }

            idx++;
            marker++;

        }

        // Print the tree
        for (char[] row : tree) {
            System.out.println(new String(row));
        }
    }

    private static int getHeight(TreeNode root, int height){

        if (root==null) return height-1;

        int left = getHeight(root.left,height+1);
        int right = getHeight(root.right,height+1);

        return Math.max(left,right);

    }

}
