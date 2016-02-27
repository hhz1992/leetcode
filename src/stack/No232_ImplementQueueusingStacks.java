package stack;

import java.util.Stack;

/**
 * Created by Huanzhou on 2016/1/26.
 */
public class No232_ImplementQueueusingStacks {

    private Stack<Integer> input;
    private Stack<Integer> output;

    No232_ImplementQueueusingStacks() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }

    public void push(int x) {
        input.push(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        peek();
        output.pop();
    }



    private int peek() {

        if (output.empty())
            while (!input.empty()) {
                output.push(input.peek());
                input.pop();
            }
        return output.peek();
    }


    // Return whether the stack is empty.
    public boolean empty() {
        return input.empty() && output.empty();
    }

}
