package study.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public static void main(String[] args) {
        Node tree = null;
        int[] inputs = new int[] { 4, 2, 1, 3, 8, 6, 7, 9 };
        for (int i = 0; i < inputs.length; i++) {
            tree = insertRecursive(tree, inputs[i]);
        }

        BTreePrinter.printNode(tree);

        // printLevel(tree, 3);
        System.out.println(lca(tree, 6, 7).data);

        System.out.println();

        // System.out.print("Height: " + maxHeight(tree));
    }

    // use loop
    public static Node insert(Node root, int value) {
        Node tempNode = new Node(value);

        Node current, parent;

        if (root == null) {
            root = tempNode;
        } else {
            current = root;
            parent = null;

            while (true) {
                parent = current;
                if (value < parent.data) {
                    current = parent.left;
                    if (current == null) {
                        parent.left = tempNode;
                        break;
                    }

                } else {
                    current = parent.right;
                    if (current == null) {
                        parent.right = tempNode;
                        break;
                    }
                }
            }
        }

        return root;
    }

    // use recursive
    public static Node insertRecursive(Node root, int value) {
        if (root == null) {
            return new Node(value);
        } else {
            Node cur;
            if (value <= root.data) {
                cur = insertRecursive(root.left, value);
                root.left = cur;
            } else {
                cur = insertRecursive(root.right, value);
                root.right = cur;
            }
            return root;
        }
    }

    public static void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static int maxHeight(Node node) {
        if (node == null)
            return -1;

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

        System.out.println(node.data);
        printTree(node.left);
        printTree(node.right);
    }

    // check whether tree is BST, if left < node < right
    public static boolean checkBST(Node root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean check(Node n, int min, int max) {
        if (n == null)
            return true;
        if (n.data <= min || n.data >= max)
            return false;
        return check(n.left, min, n.data) && check(n.right, n.data, max);
    }

    // print top view left to right
    public static void topView(Node root) {
        topViewLeft(root);
        topViewRight(root.right);
    }

    public static void topViewLeft(Node root) {
        if (root == null)
            return;
        topViewLeft(root.left);
        System.out.print(root.data + " ");
    }

    public static void topViewRight(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        topViewRight(root.right);
    }

    // print node by level
    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.print(n.data + " ");
            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
    }

    // print level
    public static void printLevel(Node root, int level) {
        Queue<Node> queue = new LinkedList<Node>();
        Queue<Integer> levelQ = new LinkedList<>();

        queue.add(root);
        levelQ.add(1);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            Integer l = levelQ.poll();
            if (l == level) {
                System.out.print(n.data + " ");
            } else {
                l++;
                if (n.left != null) {
                    queue.add(n.left);
                    levelQ.add(l);
                }
                if (n.right != null) {
                    queue.add(n.right);
                    levelQ.add(l);
                }
            }
        }
    }

    // Lowest Common Ancestor
    public static Node lca(Node root,int v1,int v2) {

        if (root.data < v1 && root.data < v2) {
            return lca(root.right, v1, v2);
        } else if (root.data > v1 && root.data > v2) {
            return lca(root.left, v1, v2);
        }

        return root;
    }
}