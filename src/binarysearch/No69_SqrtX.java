package binarysearch;

public class No69_SqrtX {

	public static int sqrtsolution(int x, int y, int num) {
		if (x == y || x == y-1)
			 if(y*y <= num)
				 return y;
			 else return x;
		
		int s = (x + y) / 2;
		if(s > 46341)
			return  sqrtsolution(x, 46340, num);
		int z = s * s;
		if (z == num)
			return s;
		else if (z > num)
			return sqrtsolution(x, s, num);
		else
			return sqrtsolution(s, y, num);
	}

	public static int sqrt(int x) {

		if (x == 4)
			return 2;
		if(x == 0 )
			return 0;

		return sqrtsolution(1, x / 2 +1, x);

	}

	public static void main(String[] args) {

		System.out.println(sqrt(2147483647));
		
	}

}
