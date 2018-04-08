package study.stack;

import java.util.EmptyStackException;

public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) return null;
        T t = top.data;
        top = top.next;

        return t;
    }

    public void push(T data) {
        StackNode<T> n = new StackNode<T>(data);
        n.next = top;
        top = n;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}