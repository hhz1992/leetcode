package string;

/**
 * Created by Huanzhou on 2016/1/20.
 */
public class No38_CountAndSay {

    public static String countAndSay(int n) {
        String str = "1";

        int i = 1;
        if(n==1)
            return str;

        while (i < n ) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 0; j < str.length() - 1; j++) {
                if (str.charAt(j) == str.charAt(j + 1))
                    count++;
                else {
                    sb.append(count).append(str.charAt(j));
                    count = 1;
                }
            }
            sb.append(count).append(str.charAt(str.length() - 1));
            str = sb.toString();
            i++;
        }
        return str;
    }


    public static void main(String[] args) {
        System.out.println(countAndSay(4));

    }
}
