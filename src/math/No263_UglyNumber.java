package math;

/**
 * Created by Huanzhou on 2016/2/1.
 */
public class No263_UglyNumber {

    public boolean isUgly(int num) {

        for(int i=2;i<6 && num>0;i++){
            while(num%i==0){
                num /= i;
            }
        }
        return num==1;
    }
}
