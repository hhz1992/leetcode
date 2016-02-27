package binarysearch;

/**
 * Leetcode NO35
 * @author Huanzhou
 * AC time:16:00
 * PS:无脑二分搜索，再加二分搜索的 要么是稍小于value的最近，要么就是稍大于value的最近的结论
 */
public class No35_SearchInsertPosition {
	public static int searchInsert(int[] A, int target) {

		if (A == null)
			return 0;

		int low = 0, high = A.length - 1, mid = (low + high) / 2;

		while (low <= high) {
			mid = (low + high) / 2;

			if (A[mid] < target)
				low = mid + 1;
			else if (A[mid] > target)
				high = mid - 1;
			else
				return mid;
		}

		return target > A[mid] ? mid + 1 : mid;

	}

	public static void main(String[] args) {

		int[] a = { 1, 3, 5, 6 };

		System.out.println(searchInsert(a, 2));

	}

}
/*
	Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
	You may assume no duplicates in the array.
	Here are few examples.
	[1,3,5,6], 5 → 2
	[1,3,5,6], 2 → 1
	[1,3,5,6], 7 → 4
	[1,3,5,6], 0 → 0
	
	二分搜索没找到的情况下的mid的那一个值要么是稍小于target要么稍大于target，而且就处于这个临界的两点之间
	如果正好是稍大于的那个值，那么那个mid+1就是该插的地方，如果是稍小的值那么mid就是该插的地方
	
	举例来说，假设mid处比target大，那么如果插的话，mid处已经有元素，比mid处大就该插加1的位置
	相反如果mid处比target小，target要再插的话应该要插在mid的左边，所以应该target插在mid原来的地方，
	而mid和mid以后都要右移。 当然题目只要求返回一个范围就行了。
	
	hhz
	2015.2.25 16:21
	
*/
