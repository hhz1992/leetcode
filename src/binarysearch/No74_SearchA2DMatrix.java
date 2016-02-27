package binarysearch;

/**
 * Leetcode No74
 * @author Huanzhou
 * AC time: 2015.2.25 13:00
 * PS: 二维数组的二分搜索。
 */
public class No74_SearchA2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {

		if(matrix.length==0 || matrix[0].length==0)
			return false;
		
		int low_r = 0, high_r = matrix.length - 1;
		int low_c = 0, high_c = matrix[0].length - 1;
		int row = 0;
		int mid = 0;

		while (low_r <= high_r) {
			mid = (low_r + high_r) / 2;
			if (matrix[mid][0] > target)
				high_r = mid - 1;
			else if (matrix[mid][0] < target)
			low_r = mid + 1;
			else
				return true;
		}
		
		row = matrix[mid][0] < target? mid:mid-1;
		
		if(row<0 || row > matrix.length - 1)
			return false;
		
		while (low_c <= high_c) {
			mid = (low_c + high_c) / 2;
			if (matrix[row][mid] > target)
				high_c = mid - 1;
			else if (matrix[row][mid] < target)
			low_c = mid + 1;
			else
				return true;
		}

		return false;
	}

	public static void main(String[] args) {

		int[][] a = {{1,2,3},{3,4,5}};
		
		System.out.println(searchMatrix(a,3));

	}
}
/*
	Write an efficient algorithm that searches for a value in an m * n matrix. This matrix has the following properties:

	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	For example,

	Consider the following matrix:
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

	题目大意:给定一个二维数组，大小是m*n,也就是说每一行的元素是定长，而且都是按顺序排好的，第一行的最后一个数一定比第二行的第一个数小。
	要求在这个一个二维数组中进行查找某个数
	
	想法：肯定是二分查找。刚开始想这完全就是一个排好序的序列，直接把下标进行转化然后直接二分查找即可。
	start = 0;
	end = rows * cols - 1; 
	mid = (start + end) / 2;
	matrix[mid / cols][mid % cols] == target	//有点像当年dsk的partition
	公式是：
	n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
	an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];	//用这条直接就转换了
 
 	但据说这样的方法有不好的地方
 	There are two main reasons why treating the matrix as a sorted array is a bad idea, considering that it doesn't bring any improvement on time complexity : 
 	1. as zhongjp058 mentioned, m*n may cause overflow; 2. it uses multiple expensive operations such as / and %
 
 	我自己想的第二个方法是做两次二分搜索，一次只针对行，一次只针对列。具体来说因为它是有序，拿行来进行搜索，即可以判断出目标元素具体在哪一行。
	只需要拿出每一行的第一个元素作为一个序列来二分搜索。之后肯定能确定目标元素在哪一行，之后再把本行拿出来做列的二分查找。
	
	唯一要注意的是昨天想的关于如果没有找到要找的值value,那么最后的mid情况是 根据二分法，这个最近要么是稍小于value的最近，要么就是稍大于value的最近。
	即我们要做一个小判断来确定我们要下一步对哪一行中的列进行二分查找
	row = matrix[mid][0] < target? mid:mid-1;
 
 	其实两种方法的复杂度完全一样。 前者是log2(m*n) 后者是 log2m+log2n 完全一样
 	
 	 2015.2.25 14:20
 	 hhz
 	
 */
