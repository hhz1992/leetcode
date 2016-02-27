package hashTable;

import java.util.HashMap;

/**
 * Created by Huanzhou on 2016/1/31.
 */
public class No325_MaximumSizeSubarraySumEqualsk {
    public static int maxSubArrayLen(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int sum = 0, max = 0;

        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if (sum == k)
                max = i + 1;
            if (map.containsKey(sum - k))
                max = Integer.max(max, i - map.get(sum - k));

            if (!map.containsKey(sum))
                map.put(sum, i);
        }

        return max;

    }

    public static void main(String[] args) {

       int[] nums = {1,4,4};

        System.out.println( maxSubArrayLen(nums,4));


    }


}
