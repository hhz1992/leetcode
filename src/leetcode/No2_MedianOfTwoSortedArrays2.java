package leetcode;

/**
 * Leetcode No2
 * @author Huanzhou
 * Ac time:2015/2/23 1:04
 * PS: ����˼�룬�������Ǻ�������������¼��ɡ��ػ�ˢ��ʱ����ϣ���Լ����ͣ�ϣ�����Լ��а�����
 */
public class No2_MedianOfTwoSortedArrays2 {

	public double findMedianSortedArrays(int A[], int B[]) {

		if ((A.length + B.length) % 2 != 0)
			return findMedianSortedArrays(A, 0, A.length, B, 0, B.length,
					(A.length + B.length) / 2 + 1);
		else
			return (findMedianSortedArrays(A, 0, A.length, B, 0, B.length,
					(A.length + B.length) / 2) + findMedianSortedArrays(A, 0,
					A.length, B, 0, B.length, (A.length + B.length) / 2 + 1)) / 2.0;

	}

	public static int findMedianSortedArrays(int A[], int As, int Alength, int B[],
			int Bs, int Blength, int k) {
		int i = (int) ((double) Alength / (Alength + Blength) * (k - 1));
		int j = (k - 1) - i;

		int Ai_1 = ((i == 0) ? Integer.MIN_VALUE : A[As + i - 1]);
		int Bj_1 = ((j == 0) ? Integer.MIN_VALUE : B[Bs + j - 1]);
		int Ai = ((i == Alength) ? Integer.MAX_VALUE : A[As + i]);
		int Bj = ((j == Blength) ? Integer.MAX_VALUE : B[Bs + j]);

		if (Bj_1 <= Ai && Ai <= Bj)
			return Ai;
		if (Ai_1 <= Bj && Bj <= Ai)
			return Bj;

		if (Ai < Bj)
			return findMedianSortedArrays(A, As + i + 1, Alength - i - 1, B, Bs, j,
					k - i - 1);
		else
			return findMedianSortedArrays(A, As, i, B, Bs + j + 1, Blength - j - 1,
					k - j - 1);

	}

	public static void main(String[] args) {

		int[] a = { 1 };
		int[] b = { 1 };
		System.out.println(new No2_MedianOfTwoSortedArrays2()
				.findMedianSortedArrays(a, b));

	}

}


/*
 	There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. 
 	The overall run time complexity should be O(log (m+n)).
 	��ĿҪ����������Ѿ��ź�������飬�ҵ����Ǻϲ�����������λ����
 	�����룬�����Ȱ���������ϲ������ҵ���λ���������ĸ��Ӷ���O(n). ������Ҫ����O(logm + logn)���Ӷ��½����
 	Ϊ�˴ﵽO(logm + logn)�ĸ��Ӷȣ����Ǳ�����ÿ�ֵ���ʱ��A��B�Ĳ��ҿռ��۰롣
 	�ؼ�˼·:����A�����е�Ԫ��Ai,B�����е�Ԫ��Bj, ����i + j = k �C 1, 
 	1.��� Bj-1 < Ai < Bj, ��ô Ai ���ǵ�kС��Ԫ��    
 	2.������� Ai-1 < Bj < Ai, ��ô Bj ���ǵ�kС��Ԫ��
 
 	��1������ �������ǰ���������ϲ��ˣ����ںϲ���������У�Ai֮ǰ��A0~Ai-1 , ����Bj-1< Ai,�� Ai֮ǰ�� B0~Bj-1�� ��ô��Ai֮ǰȷ�����Ҹպ�ֻ��
 	i+j��Ԫ�أ���ôAi���ǵ�i+j+1��Ԫ�أ�����k��Ԫ�ء� 2ͬ��
 
	����ֻҪ�����ҵ��������������ʽ�������ҵ���k��Ԫ�أ������ҵ���λ��
	�� Ai < Bj�� ��  Bj-1 < Ai ������ʱ���ںϲ����������ֻ�ܵó�Ai�������A0~Ai-1,��B0~Bj-1�ڲ���Ai����߾Ͳ�֪���ˡ� ������Bj,Bj����߿϶���
	A0~Ai,B0~Bj-1,��Ai+1����Ҳ��֪���ˡ����ǿ���ȷ�����ǣ�Bj�����������i+1+j��Ԫ�أ���Bj����Ϊ��i+j+2��Ԫ�أ���k+1��Ԫ�ء�������ʱ��Bj�Լ�Bj
	���ұ߿϶��������ǵ�k��Ԫ���ˣ��Ϳ���ͳͳʡȥ�� �ٿ�Ai,�ϲ���������У�Ai�����A0~Ai-1,Bj-1�ֲ�С��Ai,��Bj-2С��С���ֲ�֪���ˣ������ǿ���֪��
	���ǣ�Ai��������������ӵ��Bj-2,��A0~Ai-1��B0~Bj-2,��ô�͹���i+j-1��Ԫ�أ���Ai��ദ�ڵ�i+j��λ�ã���K-1������,A0~Ai���������ǵ�k��Ԫ�أ�
	�Ϳ���ͳͳʡȥ�� ���Ը�������ķ��������Ai < Bj�� ��  Bj-1 < Ai ������ʱ�� ���ǾͿ���ʡȥA��Ai��Ai�������Ԫ�أ�B��Bj��Bj�ұߵ�Ԫ�ء�
	ͬ�� Bj < Ai. 
	�����ʹﵽ��ÿ�εݹ���С��Χ��
	ע�⣬����Χ��С��k��ֵ�ڵݹ������Ҳ����Ӧ�仯��ÿһ��ݹ���������������ȫ�µ�����A,B,���Ƕ�����������ģ����������������ҵ�һ����С�ĵ�k��
	Ԫ�ؾ��൱������һ���ҵ���Ӧ��k. k����С��ʽ����k��ȥA��B��������Ƴ���Ԫ�ظ�����
	
	�������Ҫ����λ������ô�����趨������ϲ���������Ԫ�ظ����ǻ�������ôk= length/2+1, �����ż������ô������������
	һ��k=length/2,��һ��k=length/2+1�� 
	
	�ݹ���������: ��Ϊÿ�εݹ����СA,B��������ķ�Χ��������ֱ��ʡȥ��߻��ұߣ�Java��������C�������������Ӽ���ָ��취��������Ҫһ��int��ָ��
	����Ŀ��ˣ���As��Bs (start).����Alength��Blength��ȷ����С��A,B����ĳ��ȣ���Ԫ�صĸ�����
	
	���⣺������Ҫ�ҵ�Ai,Ai-1,Bj,Bj-1���ĸ�����ͨ�����ĸ����Ĵ�С��ϵ�������ǽ�һ����С��Χ�ݹ黹���ҵ���
	�����ȥѡȡi��j�أ� 
	�Ҹտ�ʼ����ֱ���ö���˼�룬��A������ѡȡ�е���ΪAi��Ȼ��ͨ����ʽi + j = k �C 1,�ó���Ӧ��j,���ǱϾ�ͼ���� ȡһ�����˵����ӣ�����B�����һ��Ԫ�أ�
	A�����м��ٸ������ڵݹ�Ĺ�����,kȡ���˵�5������ʱA���鳤��Ϊ100������Ӧ��ȡi=50,��ôj=-46. ���Բ�����ס�Ȼ����������������ķ����϶�����Ϊ������i
	�Ĺ�����û�п���j�ķ�Χ������������ƽ��İ취���ڵó�j<0ʱ����j�����Ĳ����Ƶ�i����ȥ������j=0��i-46 = 4�� �����Ĳ����� ͬʱ����������Ӧ����һ��
	���������Ϊi��ֵû��ȡ�ã�����j��ֵ������Blength-1�� �������ֵ����ж����к͡� ���к͵Ĺ����д���������Ҿͷ����ˡ�
	
	��ÿ��������·�����
	int i = (int) ((double) Alength / (Alength + Blength) * (k - 1));
  	������i�Ĺ����У���i��j��kͬʱ���룬���ݱ��������á������Ͳ��ᷢ���κ�i,j�Ǹ������߳���length-1�����.
  	
  	��i,j��Ȼ����Ϊ0���ߵ���length,��ʱAi-1,Bj-1�ͻ������⣬����lengthʱAi,Bj�����⡣
  	����A={2}, B={3} k=1, i = 0, j = 0,��ʱ Ai-1,Bj-1��������
  	�����õ��Ƚ�����İ취��
  	int Ai_1 = ((i == 0) ? Integer.MIN_VALUE : A[As + i - 1]);
	int Bj_1 = ((j == 0) ? Integer.MIN_VALUE : B[Bs + j - 1]);
	int Ai = ((i == Alength) ? Integer.MAX_VALUE : A[As + i]);
	int Bj = ((j == Blength) ? Integer.MAX_VALUE : B[Bs + j]);
  	
  	Integer.MIN_VALUE ��һ���ǳ�С�ĳ��� Integer.MAX_VALUE��һ���ǳ���ĳ����� �����������������ͷ��β������һ���ǳ����˵�����(��ʵ��������
  	ʹ�߽��������Ӧ�� Bj-1 < Ai  �� Ai-1 < Bj  ---��MIN;  Ai <= Bj �� Bj <= Ai  ---��MAX ����)
  	
  	
  	hhz
  	2015/2/23 4:06
  
 */
