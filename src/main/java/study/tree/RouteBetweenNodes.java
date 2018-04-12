package study.tree;

import java.util.LinkedList;

public class RouteBetweenNodes {
    static class Node {
        public int data;
        public Node[] children;
        public State state;

        @Override
        public boolean equals(Object obj) {
            return this.data == ((Node)obj).data;
        }
    }
    static class Graph {
        public Node[] nodes;

        public Node[] getNodes() {
            return nodes;
        }
    }

    enum State { Unvisited, Visited, Visiting; }

    public static void main(String[] args) {

    }

    public static void buildGraph() {

    }

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
                        if (u == v) {
                            return true;
                        }
                        else {
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