package string;

/**
 * Created by Huanzhou on 2016/1/21.
 */
public class No125_ValidPalindrome {

    public static boolean  isPalindrome(String s) {

        if(s.equals(""))
            return true;

        s = s.toLowerCase();

        int posA = 0;
        int posB = s.length()-1;

        while(posA<posB){
            while(!((s.charAt(posA)>='0' && s.charAt(posA)<='9') || (s.charAt(posA)>='a' && s.charAt(posA)<='z')) ){
                if(posA>=posB)
                    break;
                posA++;
            }

            while(!((s.charAt(posB)>='0' && s.charAt(posB)<='9') || (s.charAt(posB)>='a' && s.charAt(posB)<='z'))){
                if(posA>=posB)
                    break;
                posB--;
            }

            if(s.charAt(posA)!=s.charAt(posB))
                return false;

            posA++;
            posB--;
        }
        return true;
    }



    public static void main(String[] args) {

        System.out.println(isPalindrome("0P"));

    }
}

/*
   public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
    this is cool ...

* */
