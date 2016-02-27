package string;

/**
 * Created by Huanzhou on 2016/1/20.
 */
public class No28_ImplementStrStr {

    public static int strStr(String haystack, String needle) {

        return haystack.indexOf(needle);


    }


    public static void main(String[] args) {

        System.out.println(strStr("abcd","cd"));


    }
}
