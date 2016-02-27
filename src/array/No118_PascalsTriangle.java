package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huanzhou on 2016/1/22.
 */
public class No118_PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return result;

        List<Integer> cache = new ArrayList<Integer>();
        cache.add(1);
        result.add(cache);

        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(cache.get(j)+cache.get(j-1));
            }
            list.add(1);
            result.add(list);
            cache = list;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(generate(5));



    }
}
