package string;

import java.util.*;

/**
 * Created by Huanzhou on 2016/1/21.
 */
public class No249_GroupShiftedStrings {
    public static List<List<String>> groupStrings(String[] strings) {

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();

        for (String str : strings) {
            StringBuilder key = new StringBuilder("");
            int offSet = str.charAt(0) - 'a';

            for (int i = 0; i < str.length(); i++) {
                char ch = (char) (str.charAt(i) - offSet);
                if (ch < 'a')
                    ch += 26;

                key.append(ch);
            }

            if (!map.containsKey(key.toString())) {
                List<String> list = new ArrayList<String>();
                map.put(key.toString(), list);
            }
            map.get(key.toString()).add(str);
        }

        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }


    public static void main(String[] args) {

        String[] str = {"a","a"};

        List<List<String>> list =  groupStrings(str);



    }
}
