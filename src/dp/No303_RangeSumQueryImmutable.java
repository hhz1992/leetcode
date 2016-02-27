package dp;

/**
 * Created by Huanzhou on 2016/2/2.
 */
public class No303_RangeSumQueryImmutable {

    int[] sums;

    public No303_RangeSumQueryImmutable(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            nums[i+1] += nums[i];
        }
        this.sums = nums;
    }

    public int sumRange(int i, int j) {

        if(i==0)
            return sums[j];

        return sums[j] - sums[i-1];
    }
}
