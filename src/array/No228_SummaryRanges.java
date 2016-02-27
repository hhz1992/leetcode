package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huanzhou on 2016/1/23.
 */
public class No228_SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {

        List<String> list= new ArrayList<String>();

        if(nums.length==0)
            return list;

        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }

        for(int i=0; i<nums.length;i++) {
            int  start = nums[i];

            while( i+1<nums.length && (nums[i+1]-nums[i])==1 )
                i++;

            if(start == nums[i])
                list.add(String.valueOf(nums[i]));
            else{
                list.add(String.valueOf((start)+"->"+String.valueOf(nums[i])));

            }
        }


        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        int[] array = {0,5,9};
        summaryRanges(array);

    }
}
