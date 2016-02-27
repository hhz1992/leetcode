package amazonOA;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by Huanzhou on 2016/2/13.
 */
public class WindowsMinimum {
    public static ArrayList<Integer> windowMinimum(ArrayList<Integer> list, int k){
        if(list == null || list.size() == 0 || k <= 0)
            return new ArrayList<Integer>();
        int n = list.size();
        Deque<Integer> dq = new ArrayDeque<Integer>();
        ArrayList<Integer> ret = new ArrayList<Integer>(n - k + 1);
        for(int i = 0; i < n; i ++){
            while(!dq.isEmpty() && dq.peek() < i - k + 1)
                dq.poll();
            while(!dq.isEmpty() && list.get(dq.peekLast()) > list.get(i))
                dq.pollLast();
            dq.offer(i);
            if(i >= k - 1)
                ret.add(list.get(dq.peek()));
        }
        return ret;
    }
}
