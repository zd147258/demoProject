package com.xx.test.algorithm;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseString.reverseString(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }
    public void reverseString(char[] s) {
        int num = s.length % 2 == 0 ? s.length / 2 : (s.length - 1) / 2;
        for (int i = 0; i < num; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
