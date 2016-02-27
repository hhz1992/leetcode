package hashTable;

import java.util.HashSet;

/**
 * Created by Huanzhou on 2016/1/28.
 */
public class No202_HappyNumber {


    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        int num = n;
        while (true) {
            num = sum(num);
            if(num==1)
                return true;

            if(!set.add(num))
                return false;
        }
    }


    public int sum(int n) {
        int sum = 0, remain;
        while (n > 0) {
            remain = n % 10;
            sum += remain * remain;
            n /= 10;
        }
        return sum;
    }


}
