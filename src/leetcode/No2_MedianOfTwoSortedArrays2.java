package leetcode;

/**
 * Leetcode No2
 * @author Huanzhou
 * Ac time:2015/2/23 1:04
 * PS: 分治思想，条件还是很难想出来，记下即可。重回刷题时代，希望自己加油，希望对自己有帮助。
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
 	题目要求给定两个已经排好序的数组，找到它们合并后的数组的中位数。
 	简单来想，可以先把两个数组合并，再找到中位数。这样的复杂度是O(n). 但本题要求在O(logm + logn)复杂度下解决。
 	为了达到O(logm + logn)的复杂度，我们必须在每轮迭代时将A和B的查找空间折半。
 	关键思路:假设A数组中的元素Ai,B数组中的元素Bj, 而且i + j = k – 1, 
 	1.如果 Bj-1 < Ai < Bj, 那么 Ai 就是第k小的元素    
 	2.否则，如果 Ai-1 < Bj < Ai, 那么 Bj 就是第k小的元素
 
 	拿1来看， 假设我们把两个数组合并了，那在合并后的数组中，Ai之前有A0~Ai-1 , 而且Bj-1< Ai,即 Ai之前有 B0~Bj-1。 那么在Ai之前确定而且刚好只有
 	i+j个元素，那么Ai就是第i+j+1个元素，即第k个元素。 2同理
 
	所以只要我们找到了上面的两个等式，就能找到第k个元素，即能找到中位数
	当 Ai < Bj， 但  Bj-1 < Ai 不满足时，在合并后的数组中只能得出Ai的左边有A0~Ai-1,但B0~Bj-1在不在Ai的左边就不知道了。 而对于Bj,Bj的左边肯定有
	A0~Ai,B0~Bj-1,但Ai+1在哪也不知道了。但是可以确定的是，Bj的左边至少有i+1+j个元素，即Bj至少为第i+j+2个元素，即k+1个元素。所以这时，Bj以及Bj
	的右边肯定都不会是第k个元素了，就可以统统省去。 再看Ai,合并后的数组中，Ai左边有A0~Ai-1,Bj-1又不小于Ai,但Bj-2小不小于又不知道了，但我们可以知道
	的是，Ai左边最多的情况就是拥有Bj-2,即A0~Ai-1和B0~Bj-2,那么就共有i+j-1个元素，即Ai最多处在第i+j的位置，即K-1。所以,A0~Ai都不可能是第k个元素，
	就可以统统省去。 所以根据上面的分析，如果Ai < Bj， 但  Bj-1 < Ai 不满足时， 我们就可以省去A中Ai和Ai左边所有元素，B中Bj和Bj右边的元素。
	同理 Bj < Ai. 
	这样就达到了每次递归缩小范围。
	注意，当范围缩小后，k的值在递归过程中也会相应变化，每一层递归可以想象成有两个全新的数组A,B,它们都是缩减过后的，在这两个数组中找到一个缩小的第k个
	元素就相当于在上一层找到相应的k. k的缩小方式就是k减去A或B数组左边移除的元素个数。
	
	我们如果要找中位数，那么可以设定，假设合并后的数组的元素个数是基数，那么k= length/2+1, 如果是偶数，那么就找两个数，
	一个k=length/2,另一个k=length/2+1。 
	
	递归参数的设计: 因为每次递归会缩小A,B两个数组的范围，而且是直接省去左边或右边，Java不能用像C那样用数组名加减的指针办法，所以需要一个int来指定
	数组的开端，即As和Bs (start).再用Alength和Blength来确定缩小后A,B数组的长度，即元素的个数。
	
	问题：我们需要找到Ai,Ai-1,Bj,Bj-1这四个数，通过这四个数的大小关系来决定是进一步缩小范围递归还是找到答案
	但如何去选取i和j呢？ 
	我刚开始是想直接用二分思想，在A数组中选取中点作为Ai，然后通过等式i + j = k – 1,得出相应的j,但是毕竟图样。 取一个极端的例子，假设B数组就一个元素，
	A数组有几百个个，在递归的过程中,k取到了第5个，此时A数组长度为100，按理应该取i=50,那么j=-46. 所以差的离谱。然后我在想这种情况的发生肯定是因为在设置i
	的过程中没有考虑j的范围，于是我用了平衡的办法，在得出j<0时，把j负数的部分移到i上面去，即让j=0，i-46 = 4。 这样的操作。 同时，还会有相应的另一种
	情况，即因为i的值没有取好，导致j的值超过了Blength-1。 这样我又得做判断来中和。 在中和的过程中错误层出不穷。我就放弃了。
	
	最好可以用如下方法：
	int i = (int) ((double) Alength / (Alength + Blength) * (k - 1));
  	在设置i的过程中，让i，j，k同时参与，根据比例来设置。这样就不会发生任何i,j是负数或者超过length-1的情况.
  	
  	但i,j仍然可以为0或者等于length,此时Ai-1,Bj-1就会有问题，等于length时Ai,Bj有问题。
  	比如A={2}, B={3} k=1, i = 0, j = 0,此时 Ai-1,Bj-1都不存在
  	这里用到比较巧妙的办法：
  	int Ai_1 = ((i == 0) ? Integer.MIN_VALUE : A[As + i - 1]);
	int Bj_1 = ((j == 0) ? Integer.MIN_VALUE : B[Bs + j - 1]);
	int Ai = ((i == Alength) ? Integer.MAX_VALUE : A[As + i]);
	int Bj = ((j == Blength) ? Integer.MAX_VALUE : B[Bs + j]);
  	
  	Integer.MIN_VALUE 是一个非常小的常数 Integer.MAX_VALUE是一个非常大的常数， 这样等于是在数组的头和尾各加了一个非常极端的数。(其实这样可以
  	使边界情况下相应的 Bj-1 < Ai  或 Ai-1 < Bj  ---》MIN;  Ai <= Bj 或 Bj <= Ai  ---》MAX 满足)
  	
  	
  	hhz
  	2015/2/23 4:06
  
 */
