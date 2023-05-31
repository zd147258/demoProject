package com.xx.test.algorithm;

import java.util.Locale;

public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome.isPalindrome(s));
    }
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("\\W", "").toLowerCase(Locale.ROOT);
        int len;
        if (s1.length()%2 != 0){
            len = (int) Math.floor(s1.length() / 2);
        }else {
            len = s1.length()/2;
        }
        System.out.println("s1:" + s1);
        String substring1 = s1.substring(0, len);
        System.out.println("substring1:" + substring1);
        String substring2 = s1.substring(s1.length()-len, s1.length());
        System.out.println("substring2:" + substring2);
        substring2 = new StringBuffer(substring2).reverse().toString();
        System.out.println("substring2:" + substring2);
        return substring1.equals(substring2) ? true : false;
    }
}
