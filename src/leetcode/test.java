package leetcode;

public class test {
	public static void main(String[] args) {

		System.out.println(myAtoi(" b11228552307"));



	}
	public static int myAtoi(String str) {

		if(str==null || str.equals(""))
			return 0;

		int i=0;
		while( i<str.length() && str.charAt(i)!='-' && str.charAt(i)!='+' &&  ( str.charAt(i)<'0' || str.charAt(i)>'9')   ){
			i++;
		}

		if(i==str.length())
			return 0;

		boolean flag = false;
		if(str.charAt(i)=='-'){
			flag = true;
			i++;
		}else if(str.charAt(i)=='+'){
			i++;
		}

		if( i>=str.length() || !( str.charAt(i)>='0' && str.charAt(i)<='9'))
			return 0;

		long result = 0;

		while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9'){
			result = result * 10;
			result = result+ (str.charAt(i)-'0');
			if(result > Integer.MAX_VALUE)
				return flag == false? Integer.MAX_VALUE:Integer.MIN_VALUE;
			i++;
		}

		result = (flag == false)? result:result*(-1);
		result = (result > Integer.MAX_VALUE)? Integer.MAX_VALUE:result;
		result = (result < Integer.MIN_VALUE)? Integer.MIN_VALUE:result;

		return (int)result;

	}
}
