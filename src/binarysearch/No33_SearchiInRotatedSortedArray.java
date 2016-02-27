package binarysearch;

/**
 * LeetCode No33
 * @author Huanzhou
 * AC time:2015.2.25 23:51
 * PS:二分查找找到分界点再利用取余的方式再用一次二分查找，interesting! 或者压根不管这个临界点
 */
public class No33_SearchiInRotatedSortedArray {

	public static int search(int[] A, int target) {

		if (A == null)
			return -1;

		int mid = (A.length - 1) / 2;
		int low = 0, high = A.length - 1;
		int val = 0;

		while (low <= high) {
			mid = (low + high) / 2;

			if (A[mid] > A[high]) {
				if (A[mid] > A[mid + 1]) {
					val = mid + 1;
					break;
				} else
					low = mid + 1;
			} else if (A[mid] < A[low]) {
				if (A[mid] < A[mid - 1]) {
					val = mid;
					break;
				} else
					high = mid - 1;
			} else {
				val = 0;
				break;
			}
		}

		low = 0;
		high = A.length - 1;
		int len = A.length;

		while (low <= high) {
			mid = (low + high) / 2;
			if (A[(mid + val) % len] < target) {
				low = mid + 1;
			} else if (A[(mid + val) % len] > target) {
				high = mid - 1;
			} else
				return (mid + val) % len;
		}

		return -1;

	}

	public static void main(String[] args) {

		int[] a = { 1, 1 ,1,1,1,3};

		System.out.println(search(a, 3));

	}

}


/*
	Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	You are given a target value to search. If found in the array return its index, otherwise return -1.
	You may assume no duplicate exists in the array.
	
	首先想到应该找出那个临界点，然后有了临界点的下标之后通过下标的转换自然可以再进一步进行二分查找到target.
	如何找到临界点呢，一个无脑的办法就是遍历一遍，不过如果遍历那还不如直接遍历找target呢。
	这里就应该用二分查找的思想来找临界点。对于中点mid,如果 (A[mid] < A[low]) 那么临界点一定在mid左边，
	如果A[mid] > A[high] 那么临界点一定在mid右边。 按照这种思想折半搜索。 但终止条件是什么呢？
	假设A[mid] < A[low] ， 那么在[low,mid]这个包含区间内每一个元素都有可能是临界点，我们只需要看mid本身，mid+1是不可能为临界点的。因为它在
	[low,mid]之外。 试想[4,5,6,0,1,2] 如果mid+1是临界点，那么 就不应该进入 A[mid] < A[low]， 应该进入A[mid] > A[high]。 所以，在判定临界点时
	对于A[mid] < A[low] ，我们只需要看 mid和mid-1的关系，而对于A[mid] > A[high]，只需要看mid和mid+1的关系。 通过这种搜索最终肯定能找到临界点。
	当然也不用担心mid+1或mid-1会导致数组下标溢出，[1,2,3,4,5,0]
	因为到最后会剩下4,5,0,而且5在0之前肯定会被先搜索到，这时结果已经出来了。 所以还没到mid等于length-1或者0时，如果有临界点，那么临界点肯定出来了，
	就不会执行数组[mid+1]或[mid-1]溢出的情况。 同时如果没有临界点，也不会执行，因为压根都没进A[mid] > A[high] 或 A[mid] < A[low]判断里去
	
	找到临界点之后，如何转换数组的下标，进行正常的二分查找搜索到target呢
	直接用取余的方法！ 只需要简简单单的 (mid + val) % len  就可以完全把一个有整体移位的有序数组通过下标的运算把它看成一个无暇的从A[0]开始的有序数组
	
	注意: len此时应该等于 A.length而不是 A.length-1 !!!
	
	其实本题还有一种只要一次二分搜索就能解决的办法
	取中点后，如果数组有整体移位，如果临界点在左半部分，那么右半部分肯定是有序递增的；反之如果临界点在右半部分，左半部分肯定是有序递减的
	这时只要把target与有序的那一段的头尾进行比较，看是否在内，如果在就直接在那一个区间进行二分查找了，如果不在，对另一半进行递归取中点，重复下去，
	最终的情况时，要么target在有序的那一半区间里，要么mid取到了临界点，取到之后再划分递归折半后，两个区间都是有序递增的了，这时不用管，仍然做二分查找
	方法就是看target和区间的头尾比较，看是否在这个区间里面。 
	 target = 8
	[17,18,19,20,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14]	A[mid] = 5 右边是有序，当8不在[6,14]中，舍弃右边看左边
	[17,18,19,20,0,1,2,3,4],  此时A[mid] = 0,  左边[17,20]有序，而且在，直接进行二分查找，舍弃右边
	
	所以整个程序只要这么看:看A[mid]是左边有序还是右边有序，再拿target于有序的区间的头尾比较，在的话进去二分查找，不在的话舍弃本段，在另一端递归操作
	这样根本不用管这个临界点的问题也能找到答案
	
	hhz
	2015.2.26 1:27
	

*/
