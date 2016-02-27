package amazonOA;

import java.util.ArrayList;

/**
 * Created by Huanzhou on 2016/2/13.
 */
public class WindowsSum {

    public static ArrayList<Integer> mywindowSum(ArrayList<Integer> list, int windowSize){
        if(list == null || list.size() == 0 || windowSize <= 0 || windowSize > list.size())
            return new ArrayList<Integer>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int subsum = 0;
        for(int i = 0; i < windowSize; i ++)
            subsum += list.get(i);
        ret.add(subsum);
        for(int i = windowSize; i < list.size(); i ++){
            subsum = subsum - list.get(i - windowSize) + list.get(i);
            ret.add(subsum);
        }
        return ret;
    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(-5);
        System.out.println(mywindowSum(list, -1));
    }
}
