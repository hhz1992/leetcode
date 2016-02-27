package dp;

/**
 * Created by Huanzhou on 2016/2/2.
 */
public class No198_HouseRobber {

    public int rob(int[] nums) {

        if(nums.length<=0)
            return 0;

        int[] max = new int[nums.length];

        max[0] = nums[0];

        if(nums.length==1)
            return max[0];

        max[1] = Integer.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            max[i] = Integer.max(max[i-1],max[i-2]+nums[i]);
        }

        return max[nums.length-1];


    }


}
