package test;

/**
 * Created by Huanzhou on 2016/2/13.
 */
public class Power {

    public static long func(int a, int b){

        if(b==0)
            return 1;

        if(a==0)
            return b>0?0:Long.MAX_VALUE;

        return func(a,b/2)*func(a,b/2)*func(a,b%2);

    }

    public static void main(String[] args) {

        System.out.println(func(2,2));


    }


}
