package array;

/**
 * Created by Huanzhou on 2016/1/23.
 */
public class No283_MoveZeroes {

    public static void moveZeroes(int[] nums) {

        int count = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                count++;
            else{
                nums[i-count] = nums[i];
            }
        }

        for(int i=0; i<count;i++)
            nums[nums.length-1-i] = 0;

        for(int num : nums)
            System.out.println(num);


    }

    public static void main(String[] args) {

        int[] array = {0, 1, 0, 3, 12};
        moveZeroes(array);


    }
}
