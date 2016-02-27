package Whitepages;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Huanzhou on 2016/2/19.
 */
public class test {
    public static void main(String[] args) {

        InputStreamReader stdin = new InputStreamReader(System.in);
        BufferedReader bufin = new BufferedReader(stdin);
        ArrayList<Integer> array = new ArrayList<Integer>();
        boolean failure = false;
        String str = null;

        try{
            while(true){
                str = bufin.readLine();
                if(str == null || str.equals(""))
                    break;
                int num = Integer.parseInt(str);
                if(num < 0)
                    failure = true;
                array.add(num);
            }
        }catch(Exception E){
            System.out.println("failure");
            return;
        }
        if(failure){
            System.out.println("failure");
            return;
        }else if(array.size()==1 && array.get(0)>0){
            System.out.println("0, out");
            return;
        }else{
            System.out.println(findMinJumps(array));
        }

    }

    public static String findMinJumps(ArrayList<Integer> array){


        return prepareOutput(findJumpsHelper(array));
    }

    public static String prepareOutput(ArrayList<String> jumpIndexes){
        if(jumpIndexes==null || jumpIndexes.size() == 0)
            return "failure";
        else
            jumpIndexes.add("out");

        String result = jumpIndexes.toString();
        return result.substring(1,result.length()-1);
    }

    public static ArrayList<String> findJumpsHelper(ArrayList<Integer> array){
        ArrayList<String> jumps = new ArrayList<String>();
        int lastReach = 0, curReach = 0, index = 0;
        int i;
        for(i = 0; i < array.size() ; i ++){
            if(i>curReach)
                break;
            if(i>lastReach){
                lastReach = curReach;
                jumps.add(String.valueOf(index));
            }
            if(i+array.get(i)>curReach)
                index = i;
            curReach = Math.max(curReach, i+array.get(i));
        }

        if((i>lastReach) && (jumps.size()>0) && (Integer.parseInt(jumps.get(jumps.size()-1))!=index)) {
            jumps.add(String.valueOf(index));
            lastReach = curReach;
        }
        if(lastReach > array.size() - 1 )
            return jumps;
        else
            return null;
    }



}
