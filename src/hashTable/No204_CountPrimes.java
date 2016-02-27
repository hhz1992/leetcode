package hashTable;

/**
 * Created by Huanzhou on 2016/1/29.
 */
public class No204_CountPrimes {

    public int countPrimes(int n) {

        boolean[] hash = new boolean[n + 1];
        int result = 0;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (hash[i] == false) {
                for (int j = 2; j * i < n; j++) {
                    hash[j * i] = true;
                }
            }
        }

        for(int i=2;i<n;i++)
            if(hash[i]==false)
                result++;

        return result;
    }


}
