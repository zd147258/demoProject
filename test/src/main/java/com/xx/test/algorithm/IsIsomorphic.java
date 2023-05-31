package com.xx.test.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class IsIsomorphic {
    public static void main(String[] args) {
        IsIsomorphic isIsomorphic = new IsIsomorphic();
//        System.out.println(isIsomorphic.isIsomorphic("paper", "title"));
    }
    public boolean isIsomorphic(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength){
            return false;
        }
        Map<Character, Integer> sMap = new LinkedHashMap<>();
        int sCount = 32;
        Map<Character, Integer> tMap = new LinkedHashMap<>();
        int tCount = 32;
        for (int i = 0; i < sLength; i++) {
            if (!sMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i), sCount++);
                s = s.replace(s.charAt(i), (char) sCount);
            }
            if (!tMap.containsKey(t.charAt(i))){
                tMap.put(t.charAt(i), tCount++);
                t = t.replace(t.charAt(i), (char) tCount);
            }
        }
        System.out.println("s:"+s);
        for (Map.Entry<Character, Integer> sentry : sMap.entrySet()){
            System.out.println(sentry.getKey()+":"+sentry.getValue());
        }
        System.out.println("========================");
        for (Map.Entry<Character, Integer> tentry : tMap.entrySet()){
            System.out.println(tentry.getKey()+":"+tentry.getValue());
        }
        System.out.println("t:"+t);
        if (s == t){
            return true;
        }
        return false;
    }
}
