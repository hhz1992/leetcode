package binarysearch;

/**
 * Leetcode NO35
 * @author Huanzhou
 * AC time:16:00
 * PS:���Զ����������ټӶ��������� Ҫô����С��value�������Ҫô�����Դ���value������Ľ���
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
	[1,3,5,6], 5 �� 2
	[1,3,5,6], 2 �� 1
	[1,3,5,6], 7 �� 4
	[1,3,5,6], 0 �� 0
	
	��������û�ҵ�������µ�mid����һ��ֵҪô����С��targetҪô�Դ���target�����Ҿʹ�������ٽ������֮��
	����������Դ��ڵ��Ǹ�ֵ����ô�Ǹ�mid+1���Ǹò�ĵط����������С��ֵ��ômid���Ǹò�ĵط�
	
	������˵������mid����target����ô�����Ļ���mid���Ѿ���Ԫ�أ���mid����͸ò��1��λ��
	�෴���mid����targetС��targetҪ�ٲ�Ļ�Ӧ��Ҫ����mid����ߣ�����Ӧ��target����midԭ���ĵط���
	��mid��mid�Ժ�Ҫ���ơ� ��Ȼ��ĿֻҪ�󷵻�һ����Χ�����ˡ�
	
	hhz
	2015.2.25 16:21
	
*/
