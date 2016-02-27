package leetcode;

/**
 * Leetcode No14
 * @author Huanzhou 
 * AC time:2015/2/24 16:00 
 * PS:不黑了，这题也太水了，刚开始想复杂了，搞了半天。自己稍微复杂化后的题目感觉更有考的价值...
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
	题目大意:给一个字符串数组，要求其最长的公共前序列。
	刚开始我以为 在这么多字符串中求其中的一对最长的前序列，比如{"abcd","abcef","abq"},最长的为"abc"，即str[0]和str[1]的前缀部分。
	但是题目其实是要求在字符串数组中包括所有字符串的共同前序列。 所以答案应该是"ab"
	
	个人觉得明显之前的那种想法更有考核的价值。解法是先把所有字符串排序，得到按照字典序排好的字符串数组。然后再按顺序两两比较，str[0]和str[1],
	str[1]和str[2],str[2]和str[3]，这样找到一组前序相同且长度最长的一组，就是答案。 巧妙之处在于，因为已经排好序，只要按顺序两两比较，就可以找到
	前序相同且最长的一组，而不需要每一对比较。 因为按照顺序，在字符串数组中 str[0]<=str[1]<=str[2],这种小于等于的关系让 如str[0] 和 str[2]前序相同
	的部分不可能比str[0]与str[1]的部分长。
  
   	本题就很简单了，首先找到在所有字串中长度最小的字串的length,然后以该字符串的长度作为循环变量，字符串数组中的字符串个数作为循环变量，一个横一个竖，
   	一个一个遍历，直到有不相同的即所有循环结束。
  
  	通过这题，觉得正确理解题意是非常非常重要的。 还有leetcode测试数据很喜欢弄一些非常规的，比如数组是空，str[] a={}; 一些好的办法就是直接在
  	方法中判断一下传入的数组是否为空，然后直接return空的情况。
  	
  	hhz
  	2015.2.24 16:54
  
 */
