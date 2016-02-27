package binarysearch;

/**
 * LeetCode No81
 * @author Huanzhou
 * AC time: 2015.2.26 3:10
 * PS:二分搜索针对rotated at some pivot 同时有相同元素。 只需要考虑一种特殊情况即可。
 */
public class No81_RotatedSortedArrayII {
	public static boolean search(int[] A, int target) {
		if (A == null)
			return false;

		int mid = (A.length - 1) / 2;
		int low = 0, high = A.length - 1;

		if (A[0] == target)
			return true;

		while (low < A.length && A[low] == A[A.length - 1] && A[mid] == A[low])
			low++;

		
		
		while (low <= high) {

			mid = (low + high) / 2;

			if (A[mid] == target)
				return true;

			if (A[mid] > A[high]) {
				if (A[low] <= target && A[mid] > target)
					high = mid - 1;
				else
					low = mid + 1;
			} else if (A[mid] < A[low]) {
				if (A[mid] < target && A[high] >= target)
					low = mid + 1;
				else
					high = mid - 1;
			} else {
				if (A[mid] < target)
					low = mid + 1;
				else if (A[mid] > target)
					high = mid - 1;
			}

		}
		return false;
	}

	public static void main(String[] args) {

		int[] a = { 1, 1, 3, 1 };

		System.out.println(search(a, 3));

	}

}
/*
	Follow up for "Search in Rotated Sorted Array":
	What if duplicates are allowed?
	Would this affect the run-time complexity? How and why?
	最差是O(n)，因为多了前面 排除特殊情况的操作
	Write a function to determine if a given target is in the array.
	
	题目大意:是No33的一个变种，数组中有可能存在相同的元素。
	其实在普通情况下，就算是有相同元素，依照No33的两种方法仍然可以解出来。但唯一的变数在于当相同的元素横跨数组头尾的时候。
	即A[0] == A[A.length-1] ==  A[mid] 时。这个时候就无法依照二分搜索的方法来判断target是在左边区间还是右边区间。
	[1,1,1,1,2,3,1] [1,1,2,3,1,1,1,1,1] 
	其实只要消除了刚开始A[0] == A[A.length-1]  ==  A[mid] 的情况，剩下的完全可以照搬No33的方法。
	
	我原来想应该用二分思想来消除这个情况，拿mid和low,high比较，如果相同则两边都同时递归进去，直到找到mid不等于A[low]或A[high]。
	但想想其实最差的复杂度还是得一个一个排除。 因为是两边都递归进去，没有折半。实际上是O(n)，而且不是双线程，两个递归不可能同时进行，等一个结束了
	另一个才开始，所以它能节省时间的方式就是在途中遇到了不等的情况然后break掉。 break掉后返回一个区间，这个区间就是排除过后的可用区间了。
	
	不过想想与其复杂度都是O(n)，那么还不如直接遍历来的轻松，于是在开头直接通过遍历的方式消除了这个情况。
	
	同时本题我用了与No33不同的方法，即要一次二分搜索就能解决的办法。具体实现在No33题解里面有。个人觉得这个要更好更快一点。
	
	hhz
	2015.2.26 3:51

*/
