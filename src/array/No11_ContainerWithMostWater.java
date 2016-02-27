package array;

/**
 * Created by Huanzhou on 2016/2/3.
 */
public class No11_ContainerWithMostWater {
    public int maxArea(int[] height) {

        int start=0, end=height.length-1;
        int max = 0;

        while(start<end){
            int area = (end-start)* Integer.min(height[start],height[end]);
            max = max > area ? max:area;
            if(height[start]>height[end])
                end--;
            else
                start++;
        }

        return max;
    }
}
