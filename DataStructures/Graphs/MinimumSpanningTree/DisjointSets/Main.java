package DataStructures.Graphs.MinimumSpanningTree.DisjointSets;
import java.util.*;

public class Main {

    private List<Integer> size;
    private List<Integer> parent;

    public Main(int capacity) {

        size = new ArrayList<>();
        parent = new ArrayList<>();

        for (int i = 0; i <= capacity; i++) {
            size.add(1);
            parent.add(i);
        }

    }

    public int findParent(int child) {

        if (this.parent.get(child) == child) return child;

        int par = findParent(this.parent.get(child));
        this.parent.set(child, par);
        return par;

    }

    public void unionBySize(int u, int v) {

        int uParent = findParent(u);
        int vParent = findParent(v);

        if (uParent == vParent) return;

        if (this.size.get(uParent) < this.size.get(vParent)) {
            this.parent.set(uParent, vParent);
            this.size.set(vParent, this.size.get(uParent) + this.size.get(vParent));
        } else {
            this.parent.set(vParent, uParent);
            this.size.set(uParent, this.size.get(uParent) + this.size.get(vParent));
        }

    }

    public static void main(String[] args) {

        Main disjointSet = new Main(7);

        System.out.println(disjointSet.parent);
        System.out.println(disjointSet.size + "\n");

        disjointSet.unionBySize(1, 2);
        disjointSet.unionBySize(2, 3);
        disjointSet.unionBySize(4, 5);
        disjointSet.unionBySize(6, 7);
        disjointSet.unionBySize(5, 6);

        if (disjointSet.findParent(3) == disjointSet.findParent(7)) System.out.println("success");
        else System.out.println("failure");

        disjointSet.unionBySize(3, 7);

        System.out.println("\n" + disjointSet.parent);
        System.out.println(disjointSet.size + "\n");

        if (disjointSet.findParent(3) == disjointSet.findParent(7)) System.out.println("success");
        else System.out.println("failure");

        System.out.println("\n" + disjointSet.parent);
        System.out.println(disjointSet.size);

        System.out.println(disjointSet.findParent(2));

        System.out.println("\n" + disjointSet.parent);
        System.out.println(disjointSet.size);

    }

}
