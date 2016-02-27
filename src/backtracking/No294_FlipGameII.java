package backtracking;

/**
 * Created by Huanzhou on 2016/2/24.
 */
public class No294_FlipGameII {
    public boolean canWin(String s) {

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='+' && s.charAt(i-1)=='+'){
                String str = s.substring(0,i-1)+"--"+s.substring(i+1,s.length());

                if(!canWin(str))
                    return true;
            }
        }
        return false;
    }
}
