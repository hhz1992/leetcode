package math;

/**
 * Created by Huanzhou on 2016/1/31.
 */
public class No172_FactorialTrailingZeroes {

    public int trailingZeroes(int n) {

        int result = 0;
        while(n/5>0){
            result++;
            n=n/5;
        }
        return result;
    }
}
