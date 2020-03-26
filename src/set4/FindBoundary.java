package set4;

/**
 * Find boundary of a binary tree
 */
public class FindBoundary {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.right = new Node(5);
        root.left.left = new Node(6);

        root.right.left = new Node(4);
        root.right.right = new Node(7);

        root.left.right.left = new Node(9);
        root.left.right.right = new Node(10);
        root.left.left.left = new Node(11);
        root.left.left.right = new Node(12);


        printBoundary(root);
    }

    private static void printBoundary(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }

    private static void printRightBoundary(Node right) {
        if (right == null)
            return;
        //Don't print if leaf node
        if (right.left == null && right.right == null) {
            return;
        }

        System.out.print(right.data + " ");
        if (right.right == null) {
            printLeftBoundary(right.left);
        } else {
            printLeftBoundary(right.right);
        }
    }

    private static void printLeaves(Node root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        } else {
            printLeaves(root.left);
            printLeaves(root.right);
        }
    }

    private static void printLeftBoundary(Node left) {
        if (left == null)
            return;
        //Don't print if leaf node
        if (left.left == null && left.right == null) {
            return;
        }

        System.out.print(left.data + " ");
        if (left.left == null) {
            printLeftBoundary(left.right);
        } else {
            printLeftBoundary(left.left);
        }
    }

}
