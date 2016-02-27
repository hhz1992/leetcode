package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huanzhou on 2016/2/23.
 */
public class No163_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if(nums.length==0){
            result.add(outputRange(lower,upper));
            return result;
        }
        int prev;
        if(nums[0] - lower > 0){
            result.add(outputRange(lower,nums[0]-1));
            prev = nums[0];
        }else{
            prev = lower;
        }
        for(int cur:nums){
            if(cur-prev>1){
                result.add(outputRange(prev+1,cur-1));
            }
            prev = cur;
        }
        if(upper-prev > 0){
            result.add(outputRange(prev+1,upper));
        }
        return  result;

    }

    private String outputRange(int n, int m){
        return (n==m)? String.valueOf(n): n+"->"+m;
    }
}
