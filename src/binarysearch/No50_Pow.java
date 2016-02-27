package binarysearch;

/**
 * Created by Huanzhou on 2016/2/3.
 */
public class No50_Pow {

    public double myPow(double x, int n) {

        if(n>=0)
            return pow(x,n);
        else
            return 1.0/pow(x,-n);
    }

    private double pow(double x, int n){
        if(n==0)
            return 1;

        double val = pow(x,n/2);
        if(n%2==0)
            return val*val;
        else
            return val*val*x;
    }


}
