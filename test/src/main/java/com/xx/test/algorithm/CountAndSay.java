package com.xx.test.algorithm;

public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        String s = countAndSay.countAndSay(1);
        System.out.println(s);
    }

    String str = "1";
    StringBuffer sb = new StringBuffer();
    int index = 0;

    public String countAndSay(int n) {
        char[] chars = null;
        for (int i = 0; i < n - 1; i++) {
            chars = str.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if ((j + 1) > (chars.length - 1)){
                    sb.append(j + 1 - index).append(chars[j]);
                }else if (chars[j + 1] != chars[j]){
                    sb.append(j + 1 - index).append(chars[j]);
                    index = j + 1;
                }else {
                    continue;
                }
            }
            str = sb.toString();
            sb.delete(0, sb.length());
            index = 0;
        }
        return str;
    }
}
