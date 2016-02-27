package amazonOA;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Huanzhou on 2016/2/10.
 */
public class TwoSum {
    public static int twoSumPairs(ArrayList<Integer> list, int target){
        if(list == null || list.size() < 2)
            return 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int count = 0;
        for(int i = 0; i < list.size(); i ++){
            if(hm.containsKey(target - list.get(i)))
                count += hm.get(target - list.get(i));
//			hm.put(list.get(i), 1);
			/* take duplicate into consideration */
            if(hm.containsKey(list.get(i)))
                hm.put(list.get(i), 0);
            else
                hm.put(list.get(i), 1);

        }
        return count;
    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(-1);
        list.add(5);
        list.add(11);
        list.add(6);
        list.add(4);
        list.add(5);
        list.add(5);
        System.out.println(twoSumPairs(list, 10));
    }
}
