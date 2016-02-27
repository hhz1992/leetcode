package binarysearch;

/**
 * LeetCode No33
 * @author Huanzhou
 * AC time:2015.2.25 23:51
 * PS:���ֲ����ҵ��ֽ��������ȡ��ķ�ʽ����һ�ζ��ֲ��ң�interesting! ����ѹ����������ٽ��
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
	
	�����뵽Ӧ���ҳ��Ǹ��ٽ�㣬Ȼ�������ٽ����±�֮��ͨ���±��ת����Ȼ�����ٽ�һ�����ж��ֲ��ҵ�target.
	����ҵ��ٽ���أ�һ�����Եİ취���Ǳ���һ�飬������������ǻ�����ֱ�ӱ�����target�ء�
	�����Ӧ���ö��ֲ��ҵ�˼�������ٽ�㡣�����е�mid,��� (A[mid] < A[low]) ��ô�ٽ��һ����mid��ߣ�
	���A[mid] > A[high] ��ô�ٽ��һ����mid�ұߡ� ��������˼���۰������� ����ֹ������ʲô�أ�
	����A[mid] < A[low] �� ��ô��[low,mid]�������������ÿһ��Ԫ�ض��п������ٽ�㣬����ֻ��Ҫ��mid����mid+1�ǲ�����Ϊ�ٽ��ġ���Ϊ����
	[low,mid]֮�⡣ ����[4,5,6,0,1,2] ���mid+1���ٽ�㣬��ô �Ͳ�Ӧ�ý��� A[mid] < A[low]�� Ӧ�ý���A[mid] > A[high]�� ���ԣ����ж��ٽ��ʱ
	����A[mid] < A[low] ������ֻ��Ҫ�� mid��mid-1�Ĺ�ϵ��������A[mid] > A[high]��ֻ��Ҫ��mid��mid+1�Ĺ�ϵ�� ͨ�������������տ϶����ҵ��ٽ�㡣
	��ȻҲ���õ���mid+1��mid-1�ᵼ�������±������[1,2,3,4,5,0]
	��Ϊ������ʣ��4,5,0,����5��0֮ǰ�϶��ᱻ������������ʱ����Ѿ������ˡ� ���Ի�û��mid����length-1����0ʱ��������ٽ�㣬��ô�ٽ��϶������ˣ�
	�Ͳ���ִ������[mid+1]��[mid-1]���������� ͬʱ���û���ٽ�㣬Ҳ����ִ�У���Ϊѹ����û��A[mid] > A[high] �� A[mid] < A[low]�ж���ȥ
	
	�ҵ��ٽ��֮�����ת��������±꣬���������Ķ��ֲ���������target��
	ֱ����ȡ��ķ����� ֻ��Ҫ��򵥵��� (mid + val) % len  �Ϳ�����ȫ��һ����������λ����������ͨ���±�������������һ����Ͼ�Ĵ�A[0]��ʼ����������
	
	ע��: len��ʱӦ�õ��� A.length������ A.length-1 !!!
	
	��ʵ���⻹��һ��ֻҪһ�ζ����������ܽ���İ취
	ȡ�е�����������������λ������ٽ������벿�֣���ô�Ұ벿�ֿ϶�����������ģ���֮����ٽ�����Ұ벿�֣���벿�ֿ϶�������ݼ���
	��ʱֻҪ��target���������һ�ε�ͷβ���бȽϣ����Ƿ����ڣ�����ھ�ֱ������һ��������ж��ֲ����ˣ�������ڣ�����һ����еݹ�ȡ�е㣬�ظ���ȥ��
	���յ����ʱ��Ҫôtarget���������һ�������Ҫômidȡ�����ٽ�㣬ȡ��֮���ٻ��ֵݹ��۰���������䶼������������ˣ���ʱ���ùܣ���Ȼ�����ֲ���
	�������ǿ�target�������ͷβ�Ƚϣ����Ƿ�������������档 
	 target = 8
	[17,18,19,20,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14]	A[mid] = 5 �ұ������򣬵�8����[6,14]�У������ұ߿����
	[17,18,19,20,0,1,2,3,4],  ��ʱA[mid] = 0,  ���[17,20]���򣬶����ڣ�ֱ�ӽ��ж��ֲ��ң������ұ�
	
	������������ֻҪ��ô��:��A[mid]������������ұ���������target������������ͷβ�Ƚϣ��ڵĻ���ȥ���ֲ��ң����ڵĻ��������Σ�����һ�˵ݹ����
	�����������ù�����ٽ�������Ҳ���ҵ���
	
	hhz
	2015.2.26 1:27
	

*/
