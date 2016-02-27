package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Huanzhou on 2016/1/23.
 */
public class No219_ContainsDuplicateII {



    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<Integer>();

        for(int i=0;i<nums.length;i++){
            if(i>k){
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])) return true;
        }
        return false;
    }


}
