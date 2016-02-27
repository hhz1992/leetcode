package string;

/**
 * Created by Huanzhou on 2016/2/10.
 */
public class No5_LongestPalindromicSubstring {


    public String longestPalindrome(String s) {
        String str = preProcess(s);
        int len = str.length();
        int[] p = new int[len];
        int center = 0, right = 0;

        for(int i=1;i<len-1;i++){
            int j=2*center-i;
            p[i] = (right>i)? Math.min(right-i,p[j]):0;

            while(str.charAt(i+1+p[i])==str.charAt(i-1-p[i]))
                p[i]++;

            if(i+p[i] > right){
                center = i;
                right = i+p[i];
            }
        }

        int maxLength = 0, centerIndex = 0;
        for(int i=1;i<len-1;i++){
            if(p[i] > maxLength){
                maxLength = p[i];
                centerIndex = i;
            }
        }

        centerIndex = (centerIndex - 1 - maxLength) / 2;
        return s.substring(centerIndex,centerIndex+maxLength);
    }

    private String preProcess(String str){
        if(str==null || str.length()==0)    return "^&$";
        StringBuilder sb = new StringBuilder("^");
        for(int i=0;i<str.length();i++){
            sb.append("#").append(str.substring(i,i+1));
        }
        sb.append("#$");
        return sb.toString();
    }


}
