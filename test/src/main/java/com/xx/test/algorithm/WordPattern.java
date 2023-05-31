package com.xx.test.algorithm;

import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
    }
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < s1.length + 10; i++) {
            System.out.println(pattern.charAt(i));
            if (map.containsKey(pattern.charAt(i))){
                if (s1[i] != map.get(pattern.charAt(i))){
                    return false;
                }
            }else {
                map.put(pattern.charAt(i), s1[i]);
            }
        }
        return true;
    }
}
