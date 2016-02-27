package string;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huanzhou on 2016/2/8.
 */
public class No17_LetterCombinationsofaPhoneNumber {
    String[] ds;
    List<String> result;

    public List<String> letterCombinations(String digits) {

        ds = new String[10];
        ds[2] = "abc";
        ds[3] = "def";
        ds[4] = "ghi";
        ds[5] = "jkl";
        ds[6] = "mno";
        ds[7] = "pqrs";
        ds[8] = "tuv";
        ds[9] = "wxyz";

        result = new ArrayList<String>();

        if(digits==null || digits.equals(""))
            return result;


        dfs(digits,0,new StringBuilder(""));
        return result;

    }

    void dfs(String digits,int n, StringBuilder sb){
        if(n>= digits.length()){
            result.add(sb.toString());
            return;
        }
        int index = digits.charAt(n) - '0';
        for(int i=0;i<ds[index].length();i++){
            sb.append(ds[index].charAt(i));
            dfs(digits,n+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
