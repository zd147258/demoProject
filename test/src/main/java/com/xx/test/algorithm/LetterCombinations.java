package com.xx.test.algorithm;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
/*        List<String> stringList = letterCombinations("23");
        System.out.println(stringList);*/
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> stringList = letterCombinations.letterCombinations("2");
        System.out.println(stringList);
    }

    ArrayList res = new ArrayList<>();

    public static Map<Character, String> numberMap (){
        Map<Character, String> map = new HashMap<>();
        char ch = 'a';
        StringBuffer sb = new StringBuffer();
        Character num = '2';
        for (int i = 0, length = 3; i < 27; i++) {
            if (num == '7' || num == '9'){
                length = 4;
            }
            if (sb.length() == length){
                map.put(num, sb.toString());
                num++;
                sb.delete(0, sb.length());
                length = 3;
            }
            sb.append(ch++);
        }
        return map;
    }

/*    public static List<String> letterCombinations(String digits){
        List<String> list = new ArrayList<>();
        if (StringUtils.isBlank(digits)){
            return list;
        }
        Map<Character, String> numberMap = numberMap();
        char[] chars = digits.toCharArray();
        String s1 = numberMap.get(chars[0]);
        char[] chars1 = s1.toCharArray();
        if (chars.length == 2){
            String s2 = numberMap.get(chars[1]);
            char[] chars2 = s2.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < chars1.length; i++) {
                sb.append(chars1[i]);
                for (int j = 0; j < chars2.length; j++) {
                    sb.append(chars2[j]);
                    list.add(sb.toString());
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.delete(0, sb.length());
            }
        }else {
            for (int i = 0; i < chars1.length; i++) {
                list.add(String.valueOf(chars1[i]));
            }
        }
        return list;
    }*/

    public List<String> letterCombinations(String digits) {
        if(StringUtils.isBlank(digits)){
            return res;
        }
        conbin(digits,0,new StringBuilder().append(""), numberMap());
        return res;
    }

    private void conbin(String digits, int depth, StringBuilder str,Map<Character, String> map){ ;
        if(depth == digits.length()){
            res.add(str.toString());
            return;
        }
        char temp = digits.charAt(depth);
        String s = map.get(temp);
        char[] chars = s.toCharArray();
        for(char c: chars){
            str.append(c);
            conbin(digits, depth+1, str, map);
            //撤销选择
            str.deleteCharAt(str.length() - 1);
        }
    }
}
