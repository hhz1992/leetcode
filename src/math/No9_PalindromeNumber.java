package math;

/**
 * Created by Huanzhou on 2016/1/31.
 */
public class No9_PalindromeNumber {
    public boolean isPalindrome(int x) {

        if (x<0 || (x!=0 && x%10==0)) return false;

        int rev = 0;

        while(x>rev){
            rev = rev*10 + x%10;
            x = x/10;
          }

        return (x==rev || x==rev/10);

    }
}
