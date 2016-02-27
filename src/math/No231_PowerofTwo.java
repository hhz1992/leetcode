package math;

/**
 * Created by Huanzhou on 2016/2/1.
 */
public class No231_PowerofTwo {
    public boolean isPowerOfTwo(int n) {

        if(n<=0)
            return false;

        if(n==1 || n==2)
            return true;

        while(n>0 && n!=2){
            if(n%2!=0)
                return false;
            n/=2;
        }
        return true;
    }

}
