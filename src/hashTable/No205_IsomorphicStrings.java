package hashTable;

import java.util.HashMap;

/**
 * Created by Huanzhou on 2016/1/30.
 */
public class No205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {

        if (s == null || t == null)
            if (s == null && t == null)
                return true;
            else return false;

        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<Character, Character>();

        for (int i = 0; i < s.length();i++){
            char a = s.charAt(i), b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b))
                    continue;
                else    return false;
            }else{
                if(!map.containsValue(b))
                    map.put(a,b);
                else   return false;
            }
        }
        return true;

    }


}
