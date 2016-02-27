package string;

import java.util.HashMap;

/**
 * Created by Huanzhou on 2016/2/25.
 */
public class No316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if(s==null || s.length()<=1)
            return s;

        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }

        int begin = 0, end = findMinlastIndex(map);
        int size = map.size();

        for(int i=0;i<s.length();i++){
            char minChar = 'z' + 1;
            for(int k=begin;k<=end;k++){
                if(map.containsKey(s.charAt(k)) && s.charAt(k)<minChar){
                    minChar = s.charAt(k);
                    begin = k+1;
                }
            }
            sb.append(minChar);
            if (i == size-1) break;

            map.remove(minChar);
            if(minChar == s.charAt(end))
                end = findMinlastIndex(map);
        }

        return sb.toString();
    }

    private int findMinlastIndex(HashMap<Character,Integer> map){
        if(map==null || map.isEmpty())  return -1;
        int minLastIndex = Integer.MAX_VALUE;
        for(int index:map.values()){
            minLastIndex = Math.min(minLastIndex,index);
        }
        return minLastIndex;
    }

    public static void main(String[] args) {

    }
}
