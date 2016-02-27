package array;

/**
 * Created by Huanzhou on 2016/2/23.
 */
public class No209_MinimumSizeSubarraySum {

    public static int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0, result = Integer.MIN_VALUE, sum = 0;

        while(end<nums.length){
            while(sum<s && end<nums.length){
                sum += nums[end++];
            }
            if(sum<s)   break;
            while(start<end && sum>=s){
                sum -= nums[start++];
            }
            if(end-start+1<result)
                result = end-start+1;
        }

        return result==Integer.MIN_VALUE?0:result;

    }

    public static void main(String[] args) {
        int[] nums = {1,4,4};

        System.out.println(minSubArrayLen(4,nums));

    }
}
