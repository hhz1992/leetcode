package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Huanzhou on 2016/2/3.
 */
public class No15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<nums.length-2;i++){

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int target = 0-nums[i];
            int start=i+1, end=nums.length-1;

            while(start < end){
                int sum = nums[start]+nums[end];
                if(sum == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    while(start<end && nums[start]==nums[start+1]) start++;
                    while(start<end && nums[end]==nums[end-1]) end--;
                    start++;
                    end--;

                }else if(sum > target)
                    end--;
                else
                    start++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] ={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));


    }
}
