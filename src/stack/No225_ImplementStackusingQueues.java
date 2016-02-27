package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Huanzhou on 2016/1/26.
 */
public class No225_ImplementStackusingQueues {

    Queue<Integer> que;

    No225_ImplementStackusingQueues(){
        que = new LinkedList<Integer>();
    }

    public void push(int x) {
        que.add(x);
        for (int i = 0; i < que.size() - 1; i++){
            que.add(que.peek());
            que.poll();
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        que.poll();
    }

    // Get the top element.
    public int top() {
        return que.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return que.isEmpty();
    }

}
