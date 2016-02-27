package array;

/**
 * Created by Huanzhou on 2016/1/22.
 */
public class No88_MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int posA = m-1, posB = n-1 ,pos = n+m-1;
        while(posB >= 0 && posA>=0 )
            nums1[pos--]=  nums1[posA] >= nums2[posB]? nums1[posA--] : nums2[posB--];

        while(posB >=0)
            nums1[pos--] = nums2[posB--];

        // Since the objective is to merge nums1 and nums2 into nums1, the total length is m+n if we only reach all the elements in nums2,
        // not all the elements in nums1, the remain elements in nums1 can stay there, and they are in right position.
        // We do not need to move them.
        // therefore we only need to think the condition that all the nums1 elements are reached, left elements in nums2
    }


    public static void main(String[] args) {

        int[] nums1 = {1,2,3,4,5,0,0,0,0,0};
        int[] nums2 = {2,2,6,7,8};

        merge(nums1,5,nums2,5);



    }
}
