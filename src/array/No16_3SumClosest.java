package array;

import java.util.Arrays;

/**
 * Created by Huanzhou on 2016/2/8.
 */
public class No16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {

        int result = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int start = i+1, end = nums.length-1;
            while(start<end){
                int sum = nums[start]+nums[end] + nums[i];
                if(sum>target)
                    end--;
                else
                    start++;

                result = Math.abs(result-target)> Math.abs(sum-target)? sum:result;

            }
        }
        return result;
    }
}
