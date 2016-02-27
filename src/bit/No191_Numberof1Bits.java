package bit;

/**
 * Created by Huanzhou on 2016/2/2.
 */
public class No191_Numberof1Bits {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {

        int result = 0;
        for(int i=0;i<32;i++){
            if((n&1) == 1)
                result++;
            n>>>=1;
        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println(hammingWeight(11));

    }

}
