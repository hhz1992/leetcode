package hashTable;

/**
 * Created by Huanzhou on 2016/1/30.
 */
public class No299_BullsandCows {
    public static String getHint(String secret, String guess) {

        int[] hash = new int[10];
        int A = 0, B = 0;

        for (char c : secret.toCharArray()) {
            hash[c-'0']++;
        }


        for (int i = 0; i < secret.length(); i++) {
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if(a==b) {
                A++;
                hash[b - '0']--;
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            char a = secret.charAt(i);
            char b = guess.charAt(i);

            if(a==b)
                continue;

            if(hash[b-'0']>0) {
                 B++;
                hash[b-'0']--;
            }
        }
        return A+"A"+B+"B";
    }

    public static void main(String[] args) {

        System.out.println(getHint("1123","0111"));


    }

}
