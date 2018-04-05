package study.linkedlist;

import java.util.HashSet;
import java.util.Scanner;

/**
Write code to remove duplicates from an unsorted linked list.
- Input
1->2->3->2
- Output
1->2->3
- Explanation

Solution
O(n*n), S(n)
 */
public class RemoveDups {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] a = new int[] {2, 2, 2, 2, 2, 2};

        Node ll = new Node(a[0]);

        // create link list
        for (int i = 1; i < a.length; i++) {
            ll.appendToTail(a[i]);
        }

        ll.print();

        System.out.println();

        removeDups2(ll);
        ll.print();

        in.close();
    }

    // use 2 loop, no temp data
    public static void removeDups(Node head) {
        if (head == null || head.next == null) return;

        Node p1 = head;
        while (p1 != null && p1.next != null) {
            Node p2 = p1;
            while (p2 != null && p2.next != null) {
                if (p1.data == p2.next.data) {
                    p2.next = p2.next.next;
                } else {
                    p2 = p2.next;
                }
            }
            p1 = p1.next;
        }
    }

    // use temp data
    public static void removeDups2(Node head) {
        if (head == null || head.next == null) return;
        HashSet<Integer> set = new HashSet<Integer>();

        Node prev = null;
        Node p1 = head;
        while (p1 != null) {
            if (set.contains(p1.data)) {
                prev.next = p1.next;
            } else {
                set.add(p1.data);
                prev = p1;
            }
            p1 = p1.next;
        }
    }
}