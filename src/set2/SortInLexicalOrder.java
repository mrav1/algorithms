package set2;

import java.util.Arrays;
import java.util.stream.Stream;

public class SortInLexicalOrder {

    public static void main(String[] args) {
        String[] res = sort2(new String[]{"A", "BA", "AA", "AAB"});
        System.out.println(Arrays.toString(res));
    }

    private static String[] sort2(String[] strings) {
        return Stream.of(strings).sorted().toArray(String[]::new);
    }

    private static String[] sort(String[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    String tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;

    }

    public static class SortLinkedList {

        /**
         * 1. Get mid node
         * 2. Divide the list
         * 3. merge
         */
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        public static void main(String[] args) {
            Node head = new Node(8);
            head.next = new Node(6);
            head.next.next = new Node(3);
            head.next.next.next = new Node(2);

            Node sorted = mergeSort(head);
            while (sorted != null) {
                System.out.println(sorted.data);
                sorted = sorted.next;
            }
        }

        private static Node mergeSort(Node head) {
            if (head == null || head.next == null)
                return head;

            Node middle = getMiddle(head);
            Node right = middle.next;
            middle.next = null; // Break link
            Node left = head;

            left = mergeSort(left);
            right = mergeSort(right);

            return merge(left, right);
        }

        private static Node merge(Node left, Node right) {
            Node sortedHead = null;
            if (left == null)
                return right;

            if (right == null)
                return left;

            if (left.data <= right.data) {
                sortedHead = left;
                sortedHead.next = merge(left.next, right);
            } else {
                sortedHead = right;
                sortedHead.next = merge(left, right.next);
            }
            return sortedHead;
        }

        private static Node getMiddle(Node head) {
            if (head == null)
                return head;

            Node slow = head;
            Node fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public static class Context {
        }
    }
}
