package com.xx.test.algorithm;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String str = "luffy is still joyboy";
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord(str));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}
