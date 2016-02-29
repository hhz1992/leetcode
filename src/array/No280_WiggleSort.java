package array;

/**
 * Created by hhz on 2/28/16.
 */
public class No280_WiggleSort {
    public static void wiggleSort(int[] nums) {
        for(int i=0;i<nums.length;i++)
            if(i%2==1){
                if(nums[i-1]>nums[i]) swap(nums, i);
            }else if(i!=0 && nums[i-1]<nums[i]) swap(nums, i);
    }
    public static void swap(int[] nums, int i){
        int tmp=nums[i];
        nums[i]=nums[i-1];
        nums[i-1]=tmp;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 2, 1, 6, 4};
        wiggleSort(a);
        System.out.println();
    }
}
