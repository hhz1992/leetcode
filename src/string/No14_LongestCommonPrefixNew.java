package string;

/**
 * Created by Huanzhou on 2016/2/8.
 */
public class No14_LongestCommonPrefixNew {
    public String longestCommonPrefix(String[] strs) {

        if(strs==null || strs.length == 0)
            return "";

        StringBuilder sb = new StringBuilder("");

        for(int i=0;i<strs[0].length();i++){
            char ch = strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!=ch)
                    return sb.toString();
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
