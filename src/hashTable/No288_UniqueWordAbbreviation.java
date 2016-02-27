package hashTable;

import java.util.HashMap;

/**
 * Created by Huanzhou on 2016/2/2.
 */
public class No288_UniqueWordAbbreviation {

    HashMap<String,String> map;

    public No288_UniqueWordAbbreviation(String[] dictionary) {

        map = new HashMap<String,String>();

        for(String word : dictionary){
            String str = getKey(word);

            if(map.containsKey(str)){
                if(!map.get(str).equals(word))
                    map.put(str,"");
            }else{
                map.put(str,word);
            }
        }
    }

    public boolean isUnique(String word) {
        String str = getKey(word);
        return !map.containsKey(str) || map.get(str).equals(word);
    }

    private String getKey(String word) {
        if(word.length()<=2) return word;

        return ""+ word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);

    }
}
