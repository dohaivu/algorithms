package study.tree;
import java.io.*;
import java.util.*;

public class BinarySearchTree {

    public static void main(String[] args) {
        Node tree = new Node();
        int[] inputs = new int[] {1, 3, 2, 5, 4, 6, 7};
        for (int i = 0; i < inputs.length; i++) {
            insert(tree, inputs[i]);
        }

        System.out.print("Height: " + maxHeight(tree));

    }

    static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node() {}
    }

    public static void insert(Node root, int data) {
        Node tempNode = new Node();
        tempNode.data = data;
        tempNode.left = null;
        tempNode.right = null;

        Node current, parent;

        if (root == null) {
            root = tempNode;
        } else {
            current = root;
            parent = null;

            while(true) {
                parent = current;
                if (data < parent.data) {
                    current = parent.left;
                    if (current == null) {
                        parent.left = tempNode;
                        return;
                    }

                } else {
                    current = parent.right;
                    if (current == null) {
                        parent.right = tempNode;
                        return;
                    }
                }
            }
        }
    }

    public static int maxHeight(Node node) {
        if (node == null) return 0;
        int leftHeight = maxHeight(node.left);
        int rightHeight = maxHeight(node.right);
        if (leftHeight > rightHeight)
            return 1 + leftHeight;
        else
            return 1 + rightHeight;
    }
    public static void printTree(Node node) {
        if (node == null) {
            return;
        }

        printTree(node.left);
        printTree(node.right);
        System.out.println(node.data);
    }

    public static boolean checkBST(Node root) {
	    return check(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean check(Node n, int min, int max){
        if(n==null)
            return true;
        if(n.data <= min || n.data >= max)
            return false;
        return check(n.left, min, n.data)
            && check(n.right, n.data, max);
    }
}