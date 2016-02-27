package binarysearch;

/**
 * LeetCode No34
 * @author Huanzhou
 * AC time: 2015.2.25 15:30
 * PS:无脑二分搜索
 */
public class No34_SearchForARange {
	
	 public static int[] searchRange(int[] A, int target) {
	    int[] N ={-1,-1};
		 
		 if(A==null)
			 return N;
		 
		 int low=0,high = A.length-1;
		 int mid = (high+low) /2 ;
		 boolean flag = true;
		 
		 while(flag)
		 {
			 if(low>high)
			 {
				 flag = false;
				 break;
			 }
			 mid = (high+low) /2 ;
			 if(A[mid]<target)
				 low = mid + 1;
			 else if (A[mid]>target)
				 high = mid - 1;
			 else {
				 flag = false;
				 for(int i = mid-1;;i--)
				 {
					 if(i<0  || A[i]!=target)
					 {
						 N[0] = i+1;
						 break;
					 }
				 }
				 for(int i = mid+1;;i++)
				 {
					 if( i>A.length-1 ||  A[i]!=target)
					 {
						 N[1] = i-1;
						 break;
					 }
				 }
			 }
		 }
		 
		 return N;
	 }
	 
	 public static void main(String[] args) {
		
		 int[] a = {1,1,1,1};
		 int[] b;
		 
		 b=searchRange(a,1);
		 for(int i=0;i<b.length;i++)
		 {
			 System.out.print(b[i]+" ");
			 
		 }
	}

}

/*
	Given a sorted array of integers, find the starting and ending position of a given target value.
	Your algorithm's runtime complexity must be in the order of O(log n).
	If the target is not found in the array, return [-1, -1].

	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].
	
	直接二分搜索，搜索到了之后左右一个一个扩散
	
	hhz
	2015.2.25 16:15
  
  */
