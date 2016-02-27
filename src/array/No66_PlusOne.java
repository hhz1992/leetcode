package array;

/**
 * Created by Huanzhou on 2016/1/22.
 */
public class No66_PlusOne {

    public static int[] plusOne(int[] digits) {

        for(int i=digits.length-1; i>=0 ;i--){
            if(digits[i] + 1 <= 9) {
                digits[i] += 1;
                break;
            }
            digits[i] = 0;
        }

        if(digits[0] == 0){
            int[] array = new int[digits.length+1];
            array[0] = 1;
            return array;
        }

        return digits;
    }

    public static void main(String[] args) {

        int[] array = {1,0};
        System.out.println( plusOne(array));



    }
}
