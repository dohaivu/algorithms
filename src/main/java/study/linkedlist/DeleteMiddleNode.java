package study.linkedlist;

import java.util.HashSet;
import java.util.Scanner;

/**
2.3  Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
- Input
1->2->3->4
2
- Output
1->3->4
- Explanation
remove 2

Loop and check value
O(n), S(1)
 */
public class DeleteMiddleNode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] a = new int[] {1, 2, 3, 4, 5, 6};


        Node ll = new Node(a[0]);

        // create link list
        for (int i = 1; i < a.length; i++) {
            ll.appendToTail(a[i]);
        }

        ll.print();
        System.out.println();

        int k = Integer.parseInt(in.nextLine());

        deleteMiddleNode(ll, k);
        ll.print();

        in.close();
    }

    // use 2 loop, no temp data
    public static void deleteMiddleNode(Node head, int k) {
        if (head == null || head.next == null) return;

        Node p1 = head.next;
        while (p1 != null && p1.next != null) {
            if (p1.data == k) {
                p1.data = p1.next.data;
                p1.next = p1.next.next;
            } else {
                p1 = p1.next;
            }
        }
    }


}