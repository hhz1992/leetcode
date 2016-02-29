package binarysearch;

/**
 * Created by hhz on 2/28/16.
 */
public class No162_FindPeakElement {
    public static int findPeakElement(int[] nums) {
        return binarySearch(0,nums.length-1,nums);
    }

    public static int binarySearch(int start, int end, int[] nums){

        if(start==end){
            return start;
        }else if(start==end-1){
            return nums[start]>nums[end]? start:end;
        }

        int mid = start + (end - start) / 2;
        if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
            return mid;
        }else if(nums[mid-1]<nums[mid] && nums[mid] < nums[mid+1]){
            return binarySearch(mid+1,end,nums);
        }else{
            return binarySearch(start,mid-1,nums);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,7,3,4,5,6,7};
        System.out.println( findPeakElement(a));

    }
}

/*
This problem is similar to Local Minimum. And according to the given condition, num[i] != num[i+1], there must exist a O(logN) solution. So we use binary search for this problem.

If num[i-1] < num[i] > num[i+1], then num[i] is peak
If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
If num[i-1] > num[i] < num[i+1], then both sides have peak (n is num.length)
 */
