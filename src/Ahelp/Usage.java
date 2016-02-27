package Ahelp;

import java.util.*;

/**
 * Created by Huanzhou on 2016/2/25.
 */
public class Usage {
    public static void main(String[] args) {

        //HashMap
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(1,1);
        map.remove(1);
        map.containsKey(1);
        map.isEmpty();
        for(int key:map.keySet()){}
        for(int val:map.values()){}
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            entry.getKey();
            entry.getValue();
        }
        //sort
        Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(map);

        //HashSet
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.contains(1);
        set.remove(1);
        set.isEmpty();
        set.toArray();

        //stack
        Stack<Integer> st = new Stack<Integer>();
        st.push(1);
        st.peek();
        st.pop();
        st.isEmpty();
        st.clear();

        //queue
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.peek();
        queue.poll();

        //tree



    }
}
