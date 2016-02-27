package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huanzhou on 2016/1/22.
 */
public class No119_PascalsTriangleII {
    public static List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<Integer>();

        result.add(1);

        if (rowIndex == 0)
            return result;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i-1; j >= 1; j--) {
                result.set(j,result.get(j)+result.get(j-1));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(getRow(3));

    }


}
