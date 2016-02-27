package string;

/**
 * Created by Huanzhou on 2016/1/20.
 */
public class No6_ZigZagConversion {

    public static String convert(String s, int numRows) {

        StringBuilder[] sb = new StringBuilder[numRows];            //initialize multiple dimension collection
        for (int i = 0; i < sb.length; i++)
            sb[i] = new StringBuilder();

        if (numRows <= 1)
            return s;

        int len = s.length();
        int row = 0;
        int i = 0;

        while (i < len) {
            for (int j = 0; j < numRows && i < len; j++, i++) {             //need judge  && i < len
                sb[row++].append(s.charAt(i));
            }
            row -= 2;
            for (int j = numRows - 2; j >= 1 && i < len; j--, i++) {
                sb[row--].append(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();

        for (int j = 0; j < numRows; j++) {
            result.append(sb[j]);
        }

        return result.toString();
    }


    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING", 3));

    }

}

/*
    ZigZag picture:
    http://fisherlei.blogspot.com/2013/01/leetcode-zigzag-conversion.htm
*/