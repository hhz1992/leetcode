package leetcode;

/**
 * Leetcode No8
 * @author Huanzhou
 * AC time:2015.2.24 17:30
 * PS:ˮ��
 */
public class No8_StringtoInteger {

	static public int atoi(String str) {
		long num = 0;
		int i = 0;
		int plus = 1;

		if (str.length() == 0)
			return 0;

		for (i = 0; i < str.length(); i++)
			if (str.charAt(i) != ' ')
				break;
		if (i == str.length())
			return 0;

		if (str.charAt(i) == '-') {
			plus = -1;
			i++;
		} else if (str.charAt(i) == '+')
			i++;

		for (; i < str.length(); i++)
			if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
				num = (long) (num * 10 + str.charAt(i) - 48);
				if (num * plus > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				else if (num * plus < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			} else
				break;

		return (int) num * plus;
	}

	public static void main(String[] args) {

		String str = "9223372036854775809";

			//int a = 2147483648;
		System.out.println(atoi(str));

	}

}

/*
 	Implement atoi to convert a string to an integer.
 	��Ŀ���⣺ ��stringת��һ��integer
 
 	��Ҫ˼·�ܼ򵥣���һλһλ�ı������ۼӣ�ÿ����һλ��num����10.
 	
 	Ҫע��һЩ�Ƿ����������������˵�ո�������ĸ��
 	ͬʱ��������Integer.MIN_VALUE ������ʽ�� ��ĿҪ��Stringת����ֵ����int���ܳ��ܵ�ֵ����ô�ͷ��������ֵ��
 	��ʵ�ֵ�ʱ��������long����������int,��������ֵ�����ֱ�ӷ��أ������˳����쳣�������
 	�������long������һ�ַ���������һ��max = Integer.MAX_VALUE/10 . ��λ��������Integer.MAX_VALUE/10 ʱ�����жϿ��ܽ�Ҫ������ 
 	����������һλ����Integer.MAX_VALUE�ĸ�λ7��Ƚϣ��������7��ô�ͳ����ˡ�
 
 	2015.2.24
 	hhz
 */
 
