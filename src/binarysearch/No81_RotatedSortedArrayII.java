package binarysearch;

/**
 * LeetCode No81
 * @author Huanzhou
 * AC time: 2015.2.26 3:10
 * PS:�����������rotated at some pivot ͬʱ����ͬԪ�ء� ֻ��Ҫ����һ������������ɡ�
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
	�����O(n)����Ϊ����ǰ�� �ų���������Ĳ���
	Write a function to determine if a given target is in the array.
	
	��Ŀ����:��No33��һ�����֣��������п��ܴ�����ͬ��Ԫ�ء�
	��ʵ����ͨ����£�����������ͬԪ�أ�����No33�����ַ�����Ȼ���Խ��������Ψһ�ı������ڵ���ͬ��Ԫ�غ������ͷβ��ʱ��
	��A[0] == A[A.length-1] ==  A[mid] ʱ�����ʱ����޷����ն��������ķ������ж�target����������仹���ұ����䡣
	[1,1,1,1,2,3,1] [1,1,2,3,1,1,1,1,1] 
	��ʵֻҪ�����˸տ�ʼA[0] == A[A.length-1]  ==  A[mid] �������ʣ�µ���ȫ�����հ�No33�ķ�����
	
	��ԭ����Ӧ���ö���˼������������������mid��low,high�Ƚϣ������ͬ�����߶�ͬʱ�ݹ��ȥ��ֱ���ҵ�mid������A[low]��A[high]��
	��������ʵ���ĸ��ӶȻ��ǵ�һ��һ���ų��� ��Ϊ�����߶��ݹ��ȥ��û���۰롣ʵ������O(n)�����Ҳ���˫�̣߳������ݹ鲻����ͬʱ���У���һ��������
	��һ���ſ�ʼ���������ܽ�ʡʱ��ķ�ʽ������;�������˲��ȵ����Ȼ��break���� break���󷵻�һ�����䣬�����������ų�����Ŀ��������ˡ�
	
	�����������临�Ӷȶ���O(n)����ô������ֱ�ӱ����������ɣ������ڿ�ͷֱ��ͨ�������ķ�ʽ��������������
	
	ͬʱ������������No33��ͬ�ķ�������Ҫһ�ζ����������ܽ���İ취������ʵ����No33��������С����˾������Ҫ���ø���һ�㡣
	
	hhz
	2015.2.26 3:51

*/
