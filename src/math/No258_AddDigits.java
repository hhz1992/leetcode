package math;

/**
 * Created by Huanzhou on 2016/2/1.
 */
public class No258_AddDigits {
    public int addDigits(int num) {
        int res = num % 9;
        return (res != 0 || num == 0) ? res : 9;
    }
}
