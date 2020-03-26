package set1;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> mins;

    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty() || x <= mins.peek()) {
            mins.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if (mins.peek() == x)
            mins.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mins.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-10);
        ms.push(2);
        ms.push(-2);
        ms.push(3);
        ms.push(0);
        ms.push(-1);

        System.out.println(ms.getMin());
        System.out.println(ms.stack);
        System.out.println(ms.mins);
        ms.pop();
        System.out.println(ms.getMin());

    }
}