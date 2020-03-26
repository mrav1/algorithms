package set4;

import java.util.ArrayList;
import java.util.List;

public class ParentWithMaxChildren {

    // Structure of a node of an n-ary tree
    static class Node {
        int key;
        List<Node> child;

        Node() {
            child = new ArrayList<>();
        }
    }

    // Utility function to create a new tree node
    static Node newNode(int key) {
        Node temp = new Node();
        temp.key = key;
        return temp;
    }

    static int maxChildren = 0;
    static Node maxChildrenParent = null;
    static int grandChildren = 0;
    static Node grand = null;

    public static void main(String[] args) {
        Node root = newNode(1);
        (root.child).add(newNode(2));
        (root.child).add(newNode(3));
        (root.child).add(newNode(4));
        (root.child.get(0).child).add(newNode(5));
        (root.child.get(0).child).add(newNode(6));
        (root.child.get(2).child).add(newNode(5));
        (root.child.get(2).child).add(newNode(6));
        (root.child.get(2).child).add(newNode(6));
        /*
                           1

                /           |        \
               2            3         4

           /     \                 /  \   \
          5      6                5   6   6

         */

        maxChildParent(root);

        System.out.println("Total children  : " + maxChildren);
        System.out.println("Parent          : " + maxChildrenParent.key);
        System.out.print("Children        : ");
        for (Node child : maxChildrenParent.child) {
            System.out.print(child.key + ", ");
        }

        System.out.println("\nTotal grand children  : " + grandChildren);
        System.out.println("Grand parent          : " + grand.key);
    }

    private static void maxChildParent(Node root) {
        if (root == null || root.child == null) {
            return;
        }

        if (root.child.size() > maxChildren) {
            maxChildren = root.child.size();
            maxChildrenParent = root;
        }

        int gc = 0;
        for (Node child : root.child) {
            if (child != null && child.child != null)
                gc += child.child.size();
            maxChildParent(child);
        }

        if (gc > grandChildren) {
            grandChildren = gc;
            grand = root;
        }
    }
}
