package binarysearch;

/**
 * Leetcode No74
 * @author Huanzhou
 * AC time: 2015.2.25 13:00
 * PS: ��ά����Ķ���������
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

	��Ŀ����:����һ����ά���飬��С��m*n,Ҳ����˵ÿһ�е�Ԫ���Ƕ��������Ҷ��ǰ�˳���źõģ���һ�е����һ����һ���ȵڶ��еĵ�һ����С��
	Ҫ�������һ����ά�����н��в���ĳ����
	
	�뷨���϶��Ƕ��ֲ��ҡ��տ�ʼ������ȫ����һ���ź�������У�ֱ�Ӱ��±����ת��Ȼ��ֱ�Ӷ��ֲ��Ҽ��ɡ�
	start = 0;
	end = rows * cols - 1; 
	mid = (start + end) / 2;
	matrix[mid / cols][mid % cols] == target	//�е�����dsk��partition
	��ʽ�ǣ�
	n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
	an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];	//������ֱ�Ӿ�ת����
 
 	����˵�����ķ����в��õĵط�
 	There are two main reasons why treating the matrix as a sorted array is a bad idea, considering that it doesn't bring any improvement on time complexity : 
 	1. as zhongjp058 mentioned, m*n may cause overflow; 2. it uses multiple expensive operations such as / and %
 
 	���Լ���ĵڶ��������������ζ���������һ��ֻ����У�һ��ֻ����С�������˵��Ϊ�������������������������������жϳ�Ŀ��Ԫ�ؾ�������һ�С�
	ֻ��Ҫ�ó�ÿһ�еĵ�һ��Ԫ����Ϊһ������������������֮��϶���ȷ��Ŀ��Ԫ������һ�У�֮���ٰѱ����ó������еĶ��ֲ��ҡ�
	
	ΨһҪע�����������Ĺ������û���ҵ�Ҫ�ҵ�ֵvalue,��ô����mid����� ���ݶ��ַ���������Ҫô����С��value�������Ҫô�����Դ���value�������
	������Ҫ��һ��С�ж���ȷ������Ҫ��һ������һ���е��н��ж��ֲ���
	row = matrix[mid][0] < target? mid:mid-1;
 
 	��ʵ���ַ����ĸ��Ӷ���ȫһ���� ǰ����log2(m*n) ������ log2m+log2n ��ȫһ��
 	
 	 2015.2.25 14:20
 	 hhz
 	
 */
