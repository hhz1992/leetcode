package dp;

/**
 * Created by hhz on 2/28/16.
 */
public class No279_PerfectSquares {
    public static int numSquares(int n) {

        int[] dp = new int[n+1];

            for(int i=0;i<=n;i++){
                dp[i] = Integer.MAX_VALUE;
            }

            for(int i=1;i*i<=n;i++){
                dp[i*i] = 1;
            }
            dp[0] = 0;

            for(int i=1;i<=n;i++){
                for(int j=1;i-j*j>=0;j++){
                    dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                }
            }
            return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(numSquares(2));

    }
}
