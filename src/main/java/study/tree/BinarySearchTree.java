package study.tree;
import java.io.*;
import java.util.*;

public class BinarySearchTree {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        int[] inputs = new int[] {1, 3, 2, 5, 4, 6, 7};
        for (int i = 0; i < inputs.length; i++) {
            insert(tree, inputs[i]);
        }

        System.out.print("Height: " + maxHeight(tree));
        printTree(tree);
    }

    static class TreeNode {
        public int value;
        public TreeNode leftNode;
        public TreeNode rightNode;

        public TreeNode() {}
    }

    public static void insert(TreeNode root, int data) {
        TreeNode tempNode = new TreeNode();
        tempNode.value = data;
        tempNode.leftNode = null;
        tempNode.rightNode = null;

        TreeNode current, parent;

        if (root == null) {
            root = tempNode;
        } else {
            current = root;
            parent = null;

            while(true) {
                parent = current;
                if (data < parent.value) {
                    current = parent.leftNode;
                    if (current == null) {
                        parent.leftNode = tempNode;
                        return;
                    }

                } else {
                    current = parent.rightNode;
                    if (current == null) {
                        parent.rightNode = tempNode;
                        return;
                    }
                }
            }
        }
    }

    public static int maxHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = maxHeight(node.leftNode);
        int rightHeight = maxHeight(node.rightNode);
        if (leftHeight > rightHeight)
            return 1 + leftHeight;
        else
            return 1 + rightHeight;
    }
    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }

        printTree(node.leftNode);
        printTree(node.rightNode);
        System.out.println(node.value);
    }

}