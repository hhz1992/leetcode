package amazonOA;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Huanzhou on 2016/2/13.
 */
public class optimalWeights {

    public Container findOptimalWeights(double capacity, double[] weights, int numOfContainers){
        if(weights == null || weights.length < 1){
            return null;
        }
        HashSet<Double> visited = new HashSet<Double>();
        Container res = new Container();
        res.first = Double.MIN_VALUE;
        res.second = Double.MIN_VALUE;
        Arrays.sort(weights);
        int left = 0;
        int right = weights.length - 1;
        while(left < right){
            double sum = weights[left] + weights[right];
            if(sum > capacity){
                right--;
            }else{
                if(res.first == Double.MIN_VALUE || (res.first + res.second) < sum){
                    res.first = weights[left];
                    res.second = weights[right];
                    if(sum == capacity)
                        return res;
                }
                left++;
            }
        }
        return res;
    }

}
class Container {
    public double first;
    public double second;
}
