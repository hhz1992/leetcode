package array;

/**
 * Created by Huanzhou on 2016/1/22.
 */
public class No26_RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {

        int len = nums.length;

        if(len <2)
            return len;

        int pos = 1;

        for(int i=1;i<len;i++){
            if(nums[i-1] != nums[i])
                nums[pos++] = nums[i];
        }

        return pos;
    }

    public static void main(String[] args) {

        int[] array = {-3,-1,-1,0,0,0,0,0,2};

        int res = removeDuplicates(array);

        System.out.println(res);


    }
}
