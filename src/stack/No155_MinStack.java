package stack;

import java.util.Stack;

/**
 * Created by Huanzhou on 2016/1/26.
 */
public class No155_MinStack {

    private Stack<Element> stack;

    static class Element {
        final int value;
        final int min;
        Element (final int value, final int min){
            this.value = value;
            this.min = min;
        }
    }

    public No155_MinStack() {
        stack = new Stack<Element>();
    }

    public void push(int x) {
        final int min = stack.empty()? x: Math.min(x,stack.peek().min)  ;
        stack.push(new Element(x,min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }


}
