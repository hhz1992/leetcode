package dp;

/**
 * Created by Huanzhou on 2016/2/2.
 */
public class No276_PaintFence {

    public int numWays(int n, int k) {

        if(n==0)
            return 0;
        if(n==1)
            return k;

        int diffColorCounts = k*(k-1), sameColorCounts = k;

        for(int i=2;i<=n;i++){
            int temp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
            sameColorCounts = temp;
        }
        return diffColorCounts+sameColorCounts;




    }


}
