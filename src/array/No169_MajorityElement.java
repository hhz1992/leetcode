package array;

import java.util.HashMap;

/**
 * Created by Huanzhou on 2016/1/23.
 */
public class No169_MajorityElement {

    public static int majorityElement(int[] nums) {

        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int num:nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num,1);

            if(map.get(num) > nums.length/2)
                return num;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {6,5,5};
        System.out.println(   majorityElement(nums));


    }
}
