package dp;

/**
 * Created by hhz on 2/28/16.
 */
public class No264_UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] res = new int[n+1];
        res[0] = 1;

        int t2=0,t3=0,t5=0;

        for(int i=1;i<n;i++){
            res[i] = Math.min(res[t2]*2,Math.min(res[t3]*3,res[t5]*5));
            if(res[i] == res[t2]*2)
                t2++;
            if(res[i] == res[t3]*3)
                t3++;
            if(res[i] == res[t5]*5)
                t5++;
        }
        return res[n-1];
    }

}
/*
We have an array k of first n ugly number. We only know, at the beginning, the first one, which is 1. Then

k[1] = min( k[0]x2, k[0]x3, k[0]x5). The answer is k[0]x2. So we move 2's pointer to 1. Then we test:

k[2] = min( k[1]x2, k[0]x3, k[0]x5). And so on. Be careful about the cases such as 6, in which we need to forward both pointers of 2 and 3.
 */
