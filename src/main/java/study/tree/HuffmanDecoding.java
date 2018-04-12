package study.tree;

/**
https://www.hackerrank.com/challenges/tree-huffman-decoding/problem

- Input
S="1001011"

- Output
ABACA
 */
public class HuffmanDecoding {
    static class Node {
        public  int frequency; // the frequency of this tree
        public  char data;
        public  Node left, right;

        public Node(char v) {
            data = v;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node tree = new Node('\0');

        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node BC = new Node('\0');
        BC.left = B;
        BC.right = C;

        tree.left = BC;
        tree.right = A;

        System.out.println(decode("1001011", tree));
    }

    static String decode(String S ,Node root)
    {
        if (S.length() == 0) return "";

        StringBuilder result = new StringBuilder();
        Node n = root;
        for (int i = 0; i < S.length(); i++) {
            n = '1' == S.charAt(i) ? n.right : n.left;
            if (n.left == null && n.right == null) {
                result.append(n.data);
                n = root;
            }
        }

        return result.toString();
    }
}