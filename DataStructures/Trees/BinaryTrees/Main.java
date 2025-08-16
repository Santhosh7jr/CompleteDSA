package DataStructures.Trees.BinaryTrees;

import java.util.*;

public class Main {

    private TreeNode root=null;

    public static void main(String[] args) {

        Main main = new Main();

        main.insert(new Scanner(System.in));

        PrettyPrint.prettyPrint(main.getRoot());

    }

    public TreeNode getRoot(){
        return this.root;
    }

    public void insert(Scanner scanner){

        System.out.println("enter the root node value: ");
        this.root=new TreeNode(scanner.nextInt());

        insert(this.root,scanner);

    }

    private void insert(TreeNode root,Scanner scanner){

        System.out.println("\ndo you wanna insert the value to the left of the node: "+root.val);

        if (scanner.nextInt()==1){
            System.out.println("enter the value: ");
            root.left=new TreeNode(scanner.nextInt());

            insert(root.left, scanner);

        }

        System.out.println("\ndo you wanna insert the value to the right of the node: "+root.val);

        if (scanner.nextInt()==1){
            System.out.println("enter the value: ");
            root.right=new TreeNode(scanner.nextInt());

            insert(root.right, scanner);

        }

    }

}
