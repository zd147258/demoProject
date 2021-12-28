package com.xx.test.algorithm;


import java.util.HashMap;
import java.util.Map;

public class NumDecodings {
    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        System.out.println(numDecodings.numDecodings("001012"));
    }

    public Map<Integer, String> createMap(){
        Map<Integer, String> map = new HashMap<>();
        char ch = 'a';
        for (int i = 1; i < 27; i++) {
            map.put(i, String.valueOf(ch++));
        }
        return map;
    }

    int result;

    public int numDecodings(String s) {
        backtrack(createMap(), s);
        return result;
    }

    private void backtrack(Map<Integer, String> map, String s){
        //终止条件
//        if (){
//
//        }
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i+1);
            if (!("0".equals(str))){
                s = s.substring(i, s.length());
                break;
            }
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            //取一位
            String s1 = map.get(Character.getNumericValue(chars[i]));
        }
    }
}
