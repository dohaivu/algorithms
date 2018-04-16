package study.tree;

import java.util.LinkedList;

public class Graph {
    static class Node {
        public int data;
        public Node[] children;
        public State state;

        public Node(int value) {
            this.data = value;
            this.children = new Node[]{};
        }

        @Override
        public boolean equals(Object obj) {
            return this.data == ((Node)obj).data;
        }
    }

    public Node[] nodes;
    public Node[] getNodes() {
        return nodes;
    }

    enum State { Unvisited, Visited, Visiting; }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.children = new Node[] {b, c};
        b.children = new Node[] {c, d};

        Graph g = new Graph();
        g.nodes = new Node[] {a, b, c, d, e};

        System.out.println(searchRoute(g, a, d));
    }

    public static void buildGraph() {

    }

    // search a route between two nodes, use breadth-first-search
    public static boolean searchRoute(Graph g, Node start, Node end) {
        if (start == end) return true;

        LinkedList<Node> q = new LinkedList<Node>();

        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;
        q.add(start);

        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Node v: u.children) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }

                }
                u.state = State.Visited;
            }
        }

        return false;
    }

}