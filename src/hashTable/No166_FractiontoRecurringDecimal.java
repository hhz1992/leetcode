package hashTable;

import java.util.HashMap;

/**
 * Created by Huanzhou on 2016/2/22.
 */
public class No166_FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {

        if(numerator == 0 )
            return "0";

        StringBuilder sb = new StringBuilder();
        sb.append((numerator>0)^(denominator>0)? "-":"");

        long num = Math.abs((long)numerator);
        long denum = Math.abs((long)denominator);

        sb.append(num/denum);
        num%=denum;

        if(num == 0)
            return sb.toString();

        sb.append(".");
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();

        map.put(num,sb.length());

        while(num!=0){
            num *= 10;
            sb.append(num/denum);
            num %=denum;
            if(map.containsKey(num)){
                int index = map.get(num);
                sb.insert(index,"(");
                sb.append(")");
                break;

            }else{
                map.put(num, sb.length());
            }
        }
        return sb.toString();

    }
}
