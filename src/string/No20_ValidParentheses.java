package string;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Huanzhou on 2016/1/20.
 */
public class No20_ValidParentheses {

    public static boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put(')', '(');
        map.put('[', ']');
        map.put(']', '[');
        map.put('{', '}');
        map.put('}', '{');

        Stack<Character> st = new Stack<Character>();

        if (s.length() % 2 != 0)
            return false;

        for (int i = 0; i < s.length(); i++) {

            if (st.empty())
                st.push(s.charAt(i));
            else if (map.get(st.peek()) == s.charAt(i))
                st.pop();
            else st.push(s.charAt(i));
        }

        if (st.empty())
            return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
}
