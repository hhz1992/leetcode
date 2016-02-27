package hashTable;

import java.util.HashMap;

/**
 * Created by Huanzhou on 2016/1/30.
 */
public class No290_WordPattern {
    public static boolean wordPattern(String pattern, String str) {

        HashMap<Character, String> map = new HashMap<Character, String>();

       String[] strs = str.split(" ");

        if(pattern.length()!=strs.length)
            return false;


        for (int i=0;i<pattern.length();i++) {
            char c = pattern.charAt(i);

            if (!map.containsKey(c))
                if (map.containsValue(strs[i]))
                    return false;
                else map.put(c, strs[i]);
            else if (!map.get(c).equals(strs[i]))
                return false;
        }

        return true;

    }

    public static void main(String[] args) {

        System.out.println(wordPattern("jquery","jquery"));



    }


}
