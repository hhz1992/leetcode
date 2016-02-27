package hashTable;

import java.util.HashMap;

/**
 * Created by Huanzhou on 2016/2/3.
 */
public class No1_TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0; i<nums.length;i++){

            if(map.containsKey(target-nums[i])){
                int val = map.get(target-nums[i]);
                result[0] = val < i+1 ? val:i+1;
                result[1] = val > i+1 ? val:i+1;
                return result;
            }else{
                map.put(nums[i],i+1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target  = 6;

        int[] result = twoSum(nums,6);
        System.out.println(result[0]+" "+ result[1]);


    }

}
