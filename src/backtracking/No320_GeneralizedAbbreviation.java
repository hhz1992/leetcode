package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hhz on 2/28/16.
 */
public class No320_GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {

        List<String> result = new ArrayList<String>();

        dfs(result,word,0,"",0);
        return result;
    }


    public void dfs(List<String> result,String word, int pos, String str, int count){
        if(pos == word.length()){
            if(count>0)
                str += count;
            result.add(str);
        }else{
            dfs(result,word,pos+1,str,count+1);
            dfs(result,word,pos+1,str+(count>0? count:"")+word.charAt(pos), 0);
        }

    }
}
/**
 * The idea is: for every character, we can keep it or abbreviate it. To keep it,
 * we add it to the current solution and carry on backtracking.
 * To abbreviate it, we omit it in the current solution, but increment the count, which indicates how many characters have we abbreviated.
 * When we reach the end or need to put a character in the current solution, and count is bigger than zero, we add the number into the solution.
 */
