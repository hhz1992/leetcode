package Whitepages;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Huanzhou on 2016/2/19.
 */


public class Whitepages {
    public static void main(String args[]) throws Exception {
/* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String str;
        InputStreamReader stdin = new InputStreamReader(System.in);
        BufferedReader bufin = new BufferedReader(stdin);

        ArrayList<Integer> array = new ArrayList<Integer>();
        boolean failure = false;

        try
        {
            while(true)
            {
                str = bufin.readLine();
                if(str==null || str.equals(""))
                    break;
                int num = Integer.parseInt(str);
                if(num<0)
                    failure = true;
                array.add(Integer.parseInt(str));	 //5, 6, 0, 4, 2, 4, 1, 0, 0, 4
            }
        }
        catch(Exception E)
        {
            System.out.println("failure");
            return;
        }
        if(failure)
            System.out.println("failure");
        else if(array.size()==1 && array.get(0) > 0){
            System.out.println("0, out");
            return;
        }
        else {
            System.out.print(findMinJumps(array));
        }
    }

    public static String findMinJumps(ArrayList<Integer> array) {

        String jumpIndexes = null;

        jumpIndexes = prepareOutput(findJumpsHelper(array));

        return jumpIndexes;
    }

    public static String prepareOutput(ArrayList<String> jumpIndexes) {

        if (jumpIndexes == null || jumpIndexes.size() == 0) {
            return "failure";
        } else {
            jumpIndexes.add("out");
        }
        String result = jumpIndexes.toString();
        return result.substring(1, result.length() - 1);
    }

    // Find the minimum indeces from a given array
    public static ArrayList<String> findJumpsHelper(ArrayList<Integer> array) {

        ArrayList<String> jumps = new ArrayList<String>();
        int lastReach = 0, curReach = 0, index = 0;
        int i;
        for (i = 0; i < array.size(); i++) {
            if (i > curReach)
                break;
            if (i > lastReach) {
                lastReach = curReach;
                jumps.add(String.valueOf(index));
            }
            if (i + array.get(i) > curReach)
                index = i;
            curReach = Math.max(curReach, i + array.get(i));
        }

        if ((i > lastReach) && (jumps.size() > 0) && (Integer.parseInt(jumps.get(jumps.size() - 1)) != index))
            jumps.add(String.valueOf(index));
        if (lastReach > array.size() - 1) {
            return jumps;
        } else {
            return null;
        }
    }

}