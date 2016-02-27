package string;

/**
 * Created by Huanzhou on 2016/1/20.
 */
public class No58_LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String str = s.trim();

        int pos = str.lastIndexOf(' ')+1;
        if(pos == -1)
            return str.length();
        else
            return str.length()-str.lastIndexOf(' ')-1;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));

    }
}
