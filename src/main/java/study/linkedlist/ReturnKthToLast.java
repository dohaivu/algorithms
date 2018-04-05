package study.linkedlist;

import java.util.Scanner;

/**
2.2 Implement an algorithm to find the kth to last element of a singly linked list.
- Input
1->2->3->2
1
- Output
3
- Explanation
Return 1st node from the last

Solution: recursive and 2 pointer

 */
public class ReturnKthToLast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = Integer.parseInt(in.nextLine());

        int[] a = new int[] {1, 2, 3, 4, 5, 6};

        Node ll = new Node(a[0]);

        // create link list
        for (int i = 1; i < a.length; i++) {
            ll.appendToTail(a[i]);
        }

        ll.print();

        System.out.println();

        printKthToLastRecursive(ll, k);

        Node v = printKthToLast(ll, k);
        if (v != null) {
            System.out.println(v.data);
        }

        in.close();
    }

    // 2 pointer,  O(n), S(1)
    public static Node printKthToLast(Node head, int k) {
        if (head == null || head.next == null) return null;

        Node p1 = head;
        Node p2 = head;

        // move p1 k node
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    public static int printKthToLastRecursive(Node n, int k) {
        if (n == null) {
            return 0;
        }

        int t = printKthToLastRecursive(n.next, k) + 1;
        if (t == k) {
            System.out.println(n.data);
        }

        return t;
    }

}