package com.xx.test.algorithm;


public class FirstUniqChar {
    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar("aabb"));
    }
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (freq[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
