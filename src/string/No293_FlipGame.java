package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huanzhou on 2016/1/21.
 */
public class No293_FlipGame {
    public List<String> generatePossibleNextMoves(String s) {

        List<String> list = new ArrayList<String>();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
            }
        }

        return list;

    }
}
