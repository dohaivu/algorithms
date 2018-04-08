package study.stack;

/**
3.2 How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time

Use another stack to keep track min values
 */
public class MinStack extends MyStack<Integer> {
    MyStack<Integer> minStack;

    public void push(int data) {
        super.push(data);
        if (minStack.peek() >= data) {
            minStack.push(data);
        }
    }

    public Integer pop() {
        Integer t = super.pop();

        if (t == minStack.peek()) {
            minStack.pop();
        }

        return t;
    }

    public Integer min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
        return minStack.peek();
        }
    }

}