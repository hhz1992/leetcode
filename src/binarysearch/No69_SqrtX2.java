package binarysearch;

/**
 * Leetcode No69 
 * @author Huanzhou
 * AC time 23:30
 * PS:��������ӡ�����ݹ�ǵݹ�д����Ū��һ�飬���й���ƽ����������˷�Χ�Ľ���취�� ��˵���⻹��һ����ʲôţ�ٽⷨ�İ취���Ժ�
 * �������ٿ���...
 */
public class No69_SqrtX2 {
	public static int sqrt(int x) {

		int start = 0, end = x/2;
		int mid = (start + end) / 2;
		int val;

		if(x == 0)
			return 0;
		if(x==1 || x==2 || x==3)
			return 1;
		
		if (mid >= 46341 || x >= Integer.MAX_VALUE)
			end = 46340;

		while (start <= end)  {
			mid = start + (end - start)/2;
			val = x / mid;

			if (mid == val)
				return mid;
			else if (mid < val)
				start = mid + 1;
			else
				end = mid - 1;
		}

		return x/start<start? (start-1):start;
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(sqrt(2147483647));
		
	}

}

/*
 	Implement int sqrt(int x). Compute and return the square root of x.
 	��Ŀ����:Ҫ��д�����ķ���������ֻ��ƽ����
 	
 	��ֱ�׵Ķ��������⣬���ϵ����Ĺ�ϵ��
 	
 	��һ���ط�ֵ��ע����ǣ�����Integer.MAX_VALUE��ƽ����ʱ����ѡ�������������Ĭ����Ϊ(0,Integer.MAX_VALUE/2),���������ȡ
 	mid =(Integer.MAX_VALUE/2+0)/2,����mid*mid�� Integer.MAX_VALUE������ȣ��ᳬ��������ֵ�ö�ö࣬��long�洢�����С���ʱ�Ͳ�����ôֱ��
 	���ˣ�һ���ǳ������ת���ǣ��� Ҫ�󿪷���ֵx �� mid������ �� if( x/mid == mid) �����Ͳ��õ��ĳ����洢�ռ�������ˡ�
 	���⻹��һ��Сϸ�ڣ�����������˸�����ô��ȡ��ӽ�����ƽ��ҪС�ڸ�������������x=5 Ӧ�÷���2
 	�ڿ����˸�ʱ������ʱ����ֶ�1����� Ҫ��
 	return x/start<start? (start-1):start; ����������
	��ʵ����Ϊ��������ǿ����˸���ҲҪ��һ������Ĵ𰸣����Ը��ݶ��ַ���������Ҫô����С��value�������Ҫô�����Դ���value�������
	���low=high�����Է���low����high��һ�������ҿ϶�����������ص��Ǹ�ֵ����value,��start > value ,��ôstart-1�϶�<value
	
	-��+����midֵ�����ҳ�����ֵ��valueҪ�ҵ�ֵ�Ĵ�С��ϵ
	[-,-,-,-,+,+,+] ��ʱȡmidΪ-������[mid+1,high]��Ϊ [+,+,+],�����Ϊ����������������ҵĿ϶��ǵ�һ��+
	[-,-,-,+,+,+,+] ���ͬ�ϣ�����ҵ��������һ��-��
	���������ٽ������ͬС�졣 ���������֮����ľ���ֵûʲô��ϵ��ֻ����ż���йء�

 	˵һ�¶������������±�����
 	����˼·������һ������[low,high]������������Զ��ֵ���ʽ�ҵ���Ӧ��ֵvalue��ÿ��ѡȡ��Ŀ����mid,��(high+low)/2,�����ֵ����Ҫ�ҵģ�ֱ��return.
 	���mid<value,����ʾvalue����[low,mid-1]֮�У���֮������Ȼ�� ���ԣ���ʱ�����ǵݹ黹�Ƿǵݹ�Ҳ�ã����ǰ�high = mid-1������ʱȡֵ��Χ��
 	[low,mid-1].ע�����������[]����������ϵ�� һ���ؼ����������ݹ����ѭ���Ľ���������Ӧ���� low>highʱֹͣ��Ҳ����ζ��low = high �������ü���
 	ԭ������֮ǰ�ݹ�����ķ�Χ������[low,mid-1]����[mid+1,high]�����ǰ�����ϵ��Ҳ����low,mid-1��mid+1,high���ĸ�ֵ��û�к�value�Ƚϣ��������Ƕ�
 	�п�����value�����ҵ����low��high�϶�����ȣ���������ˣ��Ǹ�ֵ��Ȼû�к�value��ȣ��ȱȹ���mid-1��mid+1�ͻ�ʹ low>high�������������еĶ������ˡ�
 	
 	������������е㣬�����ż������ô������ͨ����(high+low)/2, �ҵ���mid�������low����һ����
 	 ��������low��high�ǻ���ȵģ�������ʱ�������1��Ȼ��ȡmid��Ҫ������[mid+1,high]��[high,high] Ҫô����[low,mid-1]��[low,low].
 	���low>high������
 	������˵��value = 6, ��ʱ low = 3, high = 6, mid = 4. ��ʱ [mid+1=5,high=6] �� mid = 5 [mid+1=6,high = 6] 
 	���Լ�ס: 	1.���ַ�����������[low,high] ����low��high���ڶ��ǵȴ�ȥ�����ġ�
 				2.ȡmid = (high+low)/2 �����û�ҵ�����ô�ٽ�����һ���ݹ��ѭ��ʱ��Ҫ�ǵ� mid+1 �� mid-1 ������Ӧlow��high
 				3.����������low>high,��Ϊ�����������ܱ�֤����ÿһ�����ܵ�Ԫ�ض����������������low=highʱ����Ϊlow��high���ڴ���������������ǰ���
 				��ϵ�����Ի���Ҫ�����ֵ��ȥ������
 				4.��ʵ����Ϊ��������ǿ����˸���ҲҪ��һ������Ĵ𰸣����Ը��ݶ��ַ���������Ҫô����С��value�������Ҫô�����Դ���value�������
 				 ���������֮����ľ���ֵûʲô��ϵ��
	2015.2.25
	hhz
 
 */