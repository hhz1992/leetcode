package hashTable;

/**
 * Created by Huanzhou on 2016/1/30.
 */
public class No246_StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {

        char[] hash = new char[256];

        hash['6'] = '9';
        hash['9'] = '6';
        hash['8'] = '8';
        hash['1'] = '1';
        hash['0'] = '0';

        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (num.charAt(i) != hash[num.charAt(j)])
                return false;
        }
        return true;


    }
}
