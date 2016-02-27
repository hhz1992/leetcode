package math;

/**
 * Created by Huanzhou on 2016/2/1.
 */
public class No326_PowerofThree {

    public boolean isPowerOfThree(int n) {
        return   (n>0) && (n==1 || (n%3==0) && isPowerOfThree(n/3));
    }



}
