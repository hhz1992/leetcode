package leetcode;

import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * LeetCode No32
 * 
 * @author Huanzhou Ac time: PS:
 */
public class No32_LongestValidParentheses {

	public static int longestValidParentheses(String s) {
		int sum = 0;
		int max = 0;
		
		if(s.length()==0 || s.length()==1)
			return 0;
		
		
		
		int[] index = new int[2*s.length()];
		int[] suma = new int[2*s.length()];
		int in= 0;
		
		
		
		
		Stack<Character> sta = new Stack<Character>();
		

		for (int i = 0; i < s.length(); i++) {

			
			try {
				if (sta.peek() == '(' && s.charAt(i) == ')') {
					sta.pop();
					sum++;
				} else {
					if(s.charAt(i) == ')')
					{
						suma[in] = sum;
						index[in] = 0;
						in++;
						sum = 0;
						continue;
					}
					sta.push(s.charAt(i));
				
				}
			} catch (Exception e) {
				if(s.charAt(i) == ')')
				{
					
					if(in >0 && index[in-1]==1)
						suma[in] = sum+ suma[in-1];
					
					else
						suma[in] = sum;
					
					index[in] = 0;
					in++;
					sum = 0;
					
					continue;
				}
				
				if(s.charAt(i) == '(' && i!=0)
				{
					if(in >0 && index[in-1]==1)
						suma[in] = sum+ suma[in-1];
					else
						suma[in] = sum;
					
					index[in] = 1;
					in++;
					sum = 0;
				}
				
				sta.push(s.charAt(i));
				continue;
			}
		}
		
		if(sum!=0)
		suma[in] = sum;
		
		if(sta.empty())
		{
			if(in >0 && index[in-1]==1)
				suma[in] = sum+ suma[in-1];
		}
		
		for(int i = 0 ; i<in+1;i++)
		{
			if(suma[i]>max)
				max = suma[i];
		}
		
		return 2 * max;
	}

	public static void main(String[] args) {

		String str = "(()(((()";

		System.out.println(longestValidParentheses(str));

	}

}
