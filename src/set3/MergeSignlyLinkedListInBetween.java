package set3;

public class MergeSignlyLinkedListInBetween {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    /* +----------------------------------------+
     * | Merge l2 into l1, through a and b      |
     * +----------------------------------------|
     * |            a    b                      |
     * | l1 = (1)->(2)->(3)->(4)                |
     * |                                        |
     * | l2 = (5)->(6)->(7)->(8)->(9)           |
     * |                                        |
     * | o/p: (1)->(5)->(6)->(7)->(8)->(9)->(4) |
     * +----------------------------------------+
     *
     */
    static Node mergeInBetween(Node l1, Node l2, int a, int b) {
        int i = 1;
        Node head = new Node(l1.data);
        Node itr = head;
        while (l1 != null) {
            if (i < a - 1) {
                l1 = l1.next;
                itr.next = l1;
                i++;
            } else if (i == a - 1) {
                while (l2 != null) {
                    itr.next = l2;
                    itr = itr.next;
                    l2 = l2.next;
                }

                while (i >= a - 1 && i < b) {
                    l1 = l1.next;
                    i++;
                }
            } else {
                l1 = l1.next;
                itr.next = l1;
                itr = itr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        Node l2 = new Node(2);
        Node l3 = new Node(3);
        Node l4 = new Node(4);

        Node m1 = new Node(5);
        Node m2 = new Node(6);
        Node m3 = new Node(7);
        Node m4 = new Node(8);
        Node m5 = new Node(9);

        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        print(l1);
        System.out.println("\n--\n");
        print(m1);

        Node n = mergeInBetween(l1, m1, 2, 2);
        System.out.println("\n--\n");
        print(n);
    }

    private static void print(Node l1) {
        while (l1 != null) {
            System.out.println(l1.data);
            l1 = l1.next;
        }
    }
}
