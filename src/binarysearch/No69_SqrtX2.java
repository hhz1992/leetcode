package binarysearch;

/**
 * Leetcode No69 
 * @author Huanzhou
 * AC time 23:30
 * PS:二分搜索印象加深，递归非递归写法都弄了一遍，还有关于平方如果超出了范围的解决办法。 据说这题还有一个叫什么牛顿解法的办法，以后
 * 想起来再看吧...
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
 	题目大意:要求写开方的方法，而且只是平方根
 	
 	简单直白的二分搜索题，符合递增的关系。
 	
 	有一个地方值得注意的是，当求Integer.MAX_VALUE的平方根时，备选的区间如果按照默认设为(0,Integer.MAX_VALUE/2),很明显如果取
 	mid =(Integer.MAX_VALUE/2+0)/2,再拿mid*mid与 Integer.MAX_VALUE本事相比，会超出这个最大值好多好多，用long存储都不行。这时就不能那么直接
 	乘了，一个非常巧妙的转换是，用 要求开方的值x 与 mid整除。 即 if( x/mid == mid) 这样就不用担心超出存储空间的问题了。
 	这题还有一个小细节，即如果开不了根，那么就取最接近而且平方要小于该数的数。比如x=5 应该返回2
 	在开不了根时，答案有时会出现多1的情况 要用
 	return x/start<start? (start-1):start; 来消除问题
	其实是因为本题就算是开不了根你也要给一个最近的答案，所以根据二分法，这个最近要么是稍小于value的最近，要么就是稍大于value的最近。
	最后low=high，所以返回low还是high都一样，而且肯定的是如果返回的那个值大于value,如start > value ,那么start-1肯定<value
	
	-，+代表mid值，即找出来的值与value要找的值的大小关系
	[-,-,-,-,+,+,+] 此时取mid为-，所以[mid+1,high]即为 [+,+,+],最后因为都是正，所以最后找的肯定是第一个+
	[-,-,-,+,+,+,+] 结果同上，最后找的数是最后一个-。
	所以其它临界情况大同小异。 这个跟他们之间差距的绝对值没什么关系，只跟奇偶数有关。

 	说一下二分搜索的上下标问题
 	基本思路就是有一个区间[low,high]，在这个区间以二分的形式找到相应的值value。每次选取的目标是mid,即(high+low)/2,如果本值是想要找的，直接return.
 	如果mid<value,即表示value处在[low,mid-1]之中，反之大于亦然。 所以，这时不管是递归还是非递归也好，都是把high = mid-1。即此时取值范围是
 	[low,mid-1].注意这个括号是[]，即包含关系。 一个关键点在于最后递归或者循环的结束条件。应当是 low>high时停止，也就意味着low = high 搜索还得继续
 	原因：首先之前递归过来的范围不管是[low,mid-1]还是[mid+1,high]，都是包含关系，也就是low,mid-1或mid+1,high这四个值都没有和value比较，所以它们都
 	有可能是value。而且到最后low和high肯定会相等，就算相等了，那个值仍然没有和value相比，等比过后，mid-1或mid+1就会使 low>high，这样正好所有的都比完了。
 	
 	如果是找区间中点，如果是偶数，那么按照普通方法(high+low)/2, 找到的mid会相对于low更近一个。
 	 但是最终low和high是会相等的，到最后的时候都是相差1，然后取mid后要不就是[mid+1,high]即[high,high] 要么就是[low,mid-1]即[low,low].
 	最后low>high结束。
 	举例来说，value = 6, 此时 low = 3, high = 6, mid = 4. 此时 [mid+1=5,high=6] 再 mid = 5 [mid+1=6,high = 6] 
 	所以记住: 	1.二分法的搜索区间[low,high] 包括low和high在内都是等待去搜索的。
 				2.取mid = (high+low)/2 后如果没找到，那么再进行下一步递归或循环时，要记得 mid+1 和 mid-1 代替相应low和high
 				3.结束条件是low>high,因为这有这样才能保证里面每一个可能的元素都被搜索到，如果是low=high时，因为low和high都在待搜索区间里，而且是包含
 				关系，所以还需要把这个值拿去搜索。
 				4.其实是因为本题就算是开不了根你也要给一个最近的答案，所以根据二分法，这个最近要么是稍小于value的最近，要么就是稍大于value的最近。
 				 这个跟他们之间差距的绝对值没什么关系。
	2015.2.25
	hhz
 
 */
