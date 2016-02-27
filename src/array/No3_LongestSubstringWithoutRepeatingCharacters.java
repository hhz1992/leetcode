package array;

import java.util.HashSet;

/**
 * Created by Huanzhou on 2016/2/6.
 */
public class No3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int i = 0;
        int j = 0;
        if(s==null || s.equals(""))
            return 0;

        HashSet<Character> set = new HashSet<Character>();

        while(i<s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i++));
                max = Math.max(set.size(),max);
            }else{
                set.remove(s.charAt(j++));
            }
        }

        return max;
    }
}
