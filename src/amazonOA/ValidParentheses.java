package amazonOA;

import java.util.Stack;

/**
 * Created by Huanzhou on 2016/2/10.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s==null || s.length()==0)    return true;
        Stack<Character> st = new Stack<Character>();

        for(int i=0;i<s.length();i++){
            if(st.isEmpty())
                st.push(s.charAt(i));
            else if(s.charAt(i)-st.peek() == 1 || s.charAt(i)-st.peek()==2)
                st.pop();
            else
                st.push(s.charAt(i));
        }
        return st.isEmpty();
    }
}
