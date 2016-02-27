package heap;

import java.util.PriorityQueue;

/**
 * Created by Huanzhou on 2016/2/21.
 */
public class No215_KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int val:nums){
            pq.offer(val);

            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();

    }

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i=0;i<10;i++)
            pq.offer(i);

        for(int i=0;i<10;i++){
            System.out.println(pq.peek());
            pq.poll();
        }

        StringBuilder sb = new StringBuilder();
        sb.toString();
    }
}
