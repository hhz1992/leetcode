package array;

/**
 * Created by Huanzhou on 2016/1/23.
 */
public class No243_ShortestWordDistance {

    public static int shortestDistance(String[] words, String word1, String word2) {

        int index1 = -1, index2 = -1, min = Integer.MAX_VALUE;

        for(int i=0;i<words.length;i++){

            if(words[i].equals(word1))
                index1 = i;
            if(words[i].equals(word2))
                index2 = i;
            if(index1>=0 && index2>=0)
                min = Math.min(Math.abs(index2-index1),min);
        }

        return min;

    }

    public static void main(String[] args) {

        String[] strs={"a","c","b","a"};

        System.out.println(shortestDistance(strs,"a","b"));


    }
}
