package dp;

/**
 * Created by Huanzhou on 2016/2/2.
 */
public class No70_ClimbingStairs {

    public static int climbStairs(int n) {


        int n1 = 1, n2 = 2;
        int result = n;

        for(int i=2;i<n;i++){
            result = n1+n2;
            n1 = n2;
            n2 = result;
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(climbStairs(5));


    }



}
