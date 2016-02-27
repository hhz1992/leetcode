package hashTable;

import java.util.HashSet;

/**
 * Created by Huanzhou on 2016/1/30.
 */
public class No266_PalindromePermutation {

    public boolean canPermutePalindrome(String s) {

        HashSet<Character> set = new HashSet<Character>();

        for(char c : s.toCharArray()){
            if(!set.contains(c))
                set.add(c);
            else
                set.remove(c);
        }

        return set.size()<=1;

    }


}

/*
public boolean canPermutePalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        if (s == null)
            return true;

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (map.containsKey(a))
                map.put(a, map.get(a) + 1);
            else map.put(a, 1);
        }

        int oddCount = 0;
        if (s.length() % 2 == 0)
            oddCount = 0;
        else
            oddCount = 1;

        for (int val : map.values()) {
            if (val % 2 != 0)
                oddCount--;
            if (oddCount<0)
                return false;
        }
        return true;

    }


* */
