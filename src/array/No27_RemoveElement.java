package array;

/**
 * Created by Huanzhou on 2016/1/22.
 */
public class No27_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int pos = 0;

        for(int i=0; i< len; i++){

            if(nums[i]!=val)
                nums[pos++] = nums[i];
        }

        return pos;

    }

    public static void main(String[] args) {

    }


}
