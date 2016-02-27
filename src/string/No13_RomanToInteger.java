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
* �Ҽ������
    �ڽϴ���������ֵ��ұ߼��Ͻ�С���������֣���ʾ�����ּ�С���֡�
    �ڽϴ���������ֵ���߼��Ͻ�С���������֣���ʾ�����ּ�С���֡�
    ��������������ƣ�������I��X��C������45������д��VL��ֻ����XLV
    ������ֱ���Ϊһλ������8д��VIII������IIX��

    �ؼ�����   result += map.get(s.charAt(i)) - 2*(map.get(s.charAt(i-1)));
    ��ȥ����.
    MMXIV
    ����XIV�е�I
    ���ĵ�һ������Ϊ����˳�򣬸���ĸ��֮ǰһ���Ѿ����ӵ��ܺ�����ȥ�ˣ������������ʵ����Ӧ������Ϊ����
    IV��V-I�Ĳ��֡� �����ȰѼӵ��ܺ��е�I�������ٺ�V��ϣ����V-I�����ּ���һ�Ρ��ܹ�����

    ��Ҫ�Ĺ������� ������ֱ���Ϊһλ������8д��VIII������IIX��




* */