package dp;

/**
 * Created by hhz on 2/28/16.
 */
public class No313_SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] res = new int[n];
        int[] indexes = new int[primes.length];

        res[0] = 1;

        for(int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                min = Math.min(min,res[indexes[j]]*primes[j]);
            }

            for(int j=0;j<primes.length;j++){
                if(min == res[indexes[j]]*primes[j])
                    indexes[j]++;
            }
            res[i] = min;
        }
        return res[n-1];

    }
}
