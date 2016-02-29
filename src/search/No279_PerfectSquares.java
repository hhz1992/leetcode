package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hhz on 2/28/16.
 */
public class No279_PerfectSquares {

    public static int numSquares(int n) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=1;i<n;i++){
            if(i*i<=n)  list.add(i*i);
            else    break;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i=0;i<list.size();i++){
            if(list.get(i)==n)
                return 1;
            queue.add(list.get(i));
        }
        int count =1;
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                int sum = queue.poll();

                for(int j=0;j<list.size();j++){
                    if(sum+list.get(j)==n){
                        return count;
                    }else if(sum+list.get(j)<n && !set.contains(sum+list.get(j))){
                        set.add(sum+list.get(j));
                        queue.add(sum+list.get(j));
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println( numSquares(2));


    }
}
