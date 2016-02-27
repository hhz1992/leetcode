package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huanzhou on 2016/2/22.
 */
public class No22_GenerateParentheses {

    List<String> list = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {

        StringBuilder sb = new StringBuilder();
        dfs(sb,n,n,0,0);

        return list;

    }

    public void dfs(StringBuilder sb,int left, int right, int leftTotal, int rightTotal){

        if(left==0 && right ==0){
            list.add(sb.toString());
            return;
        }

        if(right>0 && leftTotal > rightTotal){
            dfs(sb.append(')'), left, right-1, leftTotal, rightTotal+1);
            sb.setLength(sb.length() - 1);
        }

        if(left>0){
            dfs(sb.append('('), left-1, right, leftTotal+1, rightTotal);
            sb.setLength(sb.length() - 1);
        }
    }
}
