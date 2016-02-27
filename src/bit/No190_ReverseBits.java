package bit;

/**
 * Created by Huanzhou on 2016/2/2.
 */
public class No190_ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int result = 0;

        for(int i=0;i<32;i++){
            result = result<<1 |(n&1);
            n>>>=1;
        }
        return result;

    }


}
