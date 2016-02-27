package leetcode;

/**
 * Leetcode No14
 * @author Huanzhou 
 * AC time:2015/2/24 16:00 
 * PS:�����ˣ�����Ҳ̫ˮ�ˣ��տ�ʼ�븴���ˣ����˰��졣�Լ���΢���ӻ������Ŀ�о����п��ļ�ֵ...
 */
public class No14_LongestCommonPrefix {
	static public String longestCommonPrefix(String[] strs) {

		if (strs.length == 1)
			return strs[0];
		if (strs.length == 0)
			return "";

		int maxStr = 0;
		int min = strs[0].length();

		for (int i = 1; i < strs.length; i++)
			if (strs[i].length() < min)
				min = strs[i].length();

		for (int i = 0; i < min; i++) {
			for (int j = 0; j < strs.length - 1; j++) {
				if (strs[j].charAt(i) != strs[j + 1].charAt(i))
					return (String) strs[0].subSequence(0, maxStr);
			}
			maxStr++;
		}
		return (String) strs[0].subSequence(0, maxStr);
	}

	public static void main(String[] args) {

		String[] strs = { "a1", "a1", "a1" };

		System.out.println(longestCommonPrefix(strs));

	}

}
/*
	Write a function to find the longest common prefix string amongst an array of strings.
	��Ŀ����:��һ���ַ������飬Ҫ������Ĺ���ǰ���С�
	�տ�ʼ����Ϊ ����ô���ַ����������е�һ�����ǰ���У�����{"abcd","abcef","abq"},���Ϊ"abc"����str[0]��str[1]��ǰ׺���֡�
	������Ŀ��ʵ��Ҫ�����ַ��������а��������ַ����Ĺ�ͬǰ���С� ���Դ�Ӧ����"ab"
	
	���˾�������֮ǰ�������뷨���п��˵ļ�ֵ���ⷨ���Ȱ������ַ������򣬵õ������ֵ����źõ��ַ������顣Ȼ���ٰ�˳�������Ƚϣ�str[0]��str[1],
	str[1]��str[2],str[2]��str[3]�������ҵ�һ��ǰ����ͬ�ҳ������һ�飬���Ǵ𰸡� ����֮�����ڣ���Ϊ�Ѿ��ź���ֻҪ��˳�������Ƚϣ��Ϳ����ҵ�
	ǰ����ͬ�����һ�飬������Ҫÿһ�ԱȽϡ� ��Ϊ����˳�����ַ��������� str[0]<=str[1]<=str[2],����С�ڵ��ڵĹ�ϵ�� ��str[0] �� str[2]ǰ����ͬ
	�Ĳ��ֲ����ܱ�str[0]��str[1]�Ĳ��ֳ���
  
   	����ͺܼ��ˣ������ҵ��������ִ��г�����С���ִ���length,Ȼ���Ը��ַ����ĳ�����Ϊѭ���������ַ��������е��ַ���������Ϊѭ��������һ����һ������
   	һ��һ��������ֱ���в���ͬ�ļ�����ѭ��������
  
  	ͨ�����⣬������ȷ��������Ƿǳ��ǳ���Ҫ�ġ� ����leetcode�������ݺ�ϲ��ŪһЩ�ǳ���ģ����������ǿգ�str[] a={}; һЩ�õİ취����ֱ����
  	�������ж�һ�´���������Ƿ�Ϊ�գ�Ȼ��ֱ��return�յ������
  	
  	hhz
  	2015.2.24 16:54
  
 */
