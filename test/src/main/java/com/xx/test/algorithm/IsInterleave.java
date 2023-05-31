package com.xx.test.algorithm;

public class IsInterleave {
    public static void main(String[] args) {
        IsInterleave isInterleave = new IsInterleave();
        isInterleave.isInterleave("aabcc","dbbca","aadbbcbcac");
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        int n = 0;
        while (n < chars3.length && m1(n, chars1, chars2, chars3)){}
        if (n == chars3.length - 1){
            return true;
        }else {
            return false;
        }
    }

    public boolean m1(int n, char[] chars1, char[] chars2, char[] chars3){
        for (int i = n; i < chars3.length; i++) {
            System.out.println("i:" + i);
            int count1 = 0;
            int num1 = 0;
            while (chars3[num1] == chars1[num1]){
                count1++;
                num1++;
            }
            if (count1 > 0){
                for (int j = 0; j < count1; j++) {
                    if (chars3[count1+j] != chars2[j]){
                        return false;
                    }
                }
                n += count1;
            }else {
                int count2 = 0;
                int num2 = 0;
                while (chars3[num2] == chars2[num2]){
                    count2++;
                    num2++;
                }
                if (count2 > 0){
                    for (int j = 0; j < count2; j++) {
                        if (chars3[count2+j] != chars1[j]){
                            return false;
                        }
                    }
                    n += count2;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
