package hashTable;

/**
 * Created by Huanzhou on 2016/1/28.
 */
public class No242_ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if (s == null || t == null)
            if (s == null && t == null)
                return true;
            else return false;

        if (s.length() != t.length())
            return false;

        int[] alphabet = new int[26];

        for(int i=0;i<s.length();i++)
            alphabet[s.charAt(i)-'a']++;

        for(int i=0;i<t.length();i++)
            alphabet[t.charAt(i)-'a']--;

        for(int i:alphabet)
            if(i!=0)
        return false;

        return true;




    }


}
