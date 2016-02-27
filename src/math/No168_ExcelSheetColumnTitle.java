package math;

/**
 * Created by Huanzhou on 2016/2/1.
 */
public class No168_ExcelSheetColumnTitle {

    public static String convertToTitle(int n) {

        StringBuilder str = new StringBuilder();

        while(n>0){
            n--;
            str.insert(0,(char)('A'+n%26));
            n = n/26;
        }

        return str.toString();
    }

    public static void main(String[] args) {

        System.out.println(convertToTitle(26));




    }

}
