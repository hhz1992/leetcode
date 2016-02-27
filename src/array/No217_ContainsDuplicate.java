package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Huanzhou on 2016/1/23.
 */
public class No217_ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();

        for(int num:nums){
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
