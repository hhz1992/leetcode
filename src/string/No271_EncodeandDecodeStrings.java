package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huanzhou on 2016/2/20.
 */
public class No271_EncodeandDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            sb.append(strs.get(i).length()).append('/').append(strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<String>();
        int index = 0;

        while(index<s.length()){
            int slash = s.indexOf('/',index);
            int length = Integer.parseInt(s.substring(index,slash));
            list.add(s.substring(1+slash,1+slash+length));
            index =  length + slash + 1;
        }
        return list;
    }



    public static void main(String[] args) {
        List<String> strs = new ArrayList<String>();

        strs.add("63/Rc");
        strs.add("h");
        strs.add("BmI3FS~J9#vmk");
        strs.add("7uBZ?7*/");
        strs.add("24h+X");
        strs.add("O ");



    }

}
