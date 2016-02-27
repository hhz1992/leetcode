package string;

import java.util.HashMap;

/**
 * Created by Huanzhou on 2016/1/20.
 */
public class No13_RomanToInteger {

    public static int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = map.get(s.charAt(0));

        if (s.length() == 1) {
            return result;
        }

        for (int i = 1; i < s.length(); i++) {
            if (map.get(s.charAt(i)) <= map.get(s.charAt(i - 1))) {
                result += map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i)) - 2*(map.get(s.charAt(i-1)));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "MMXIV";
        System.out.println(romanToInt(str));
    }

}

/*
* 右加左减：
    在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
    在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
    左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
    左减数字必须为一位，比如8写成VIII，而非IIX。

    关键在于   result += map.get(s.charAt(i)) - 2*(map.get(s.charAt(i-1)));
    减去两个.
    MMXIV
    比如XIV中的I
    减的第一个是因为按照顺序，该字母在之前一步已经被加到总和里面去了，但是这个数字实际上应该是作为后面
    IV中V-I的部分。 所以先把加到总和中的I减掉，再和V结合，变成V-I，就又减了一次。总共两次

    重要的规则在于 左减数字必须为一位，比如8写成VIII，而非IIX。




* */