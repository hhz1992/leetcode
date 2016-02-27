package amazonOA;

/**
 * Created by Huanzhou on 2016/2/13.
 */
public class MinMaxPath {
    public static int minMaxPath(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for(int i = 1; i < m; i ++)
            dp[i][0] = Math.min(dp[i - 1][0], matrix[i][0]);
        for(int j = 1; j < n; j ++)
            dp[0][j] = Math.min(matrix[0][j], dp[0][j - 1]);
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++)
                dp[i][j] = Math.max(Math.min(dp[i - 1][j], matrix[i][j]), Math.min(dp[i][j - 1], matrix[i][j]));
        }
        return dp[m - 1][n - 1];
    }

}
