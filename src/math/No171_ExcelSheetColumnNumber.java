package math;

/**
 * Created by Huanzhou on 2016/2/1.
 */
public class No171_ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {

        int result = 0;

        for(int i=0;i<s.length();i++)
            result = result *26 + (s.charAt(i)-'A'+1);

        return result;

    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));


    }
}
