package leetcode;

/**
 * Leetcode No8
 * @author Huanzhou
 * AC time:2015.2.24 17:30
 * PS:水题
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
 	题目大意： 将string转成一个integer
 
 	主要思路很简单，即一位一位的遍历，累加，每遍历一位，num乘以10.
 	
 	要注意一些非法的输入情况，比如说空格，其它字母。
 	同时又遇到了Integer.MIN_VALUE 这种形式。 题目要求当String转换的值大于int所能承受的值，那么就返回这个最值。
 	在实现的时候，我用了long类型来代替int,当大于最值后可以直接返回，避免了出现异常的情况。
 	如果不用long，还有一种方法是设置一个max = Integer.MAX_VALUE/10 . 当位数到达了Integer.MAX_VALUE/10 时即可判断可能将要超过。 
 	将接下来的一位数与Integer.MAX_VALUE的个位7相比较，如果大于7那么就超过了。
 
 	2015.2.24
 	hhz
 */
 
