package com.xx.test.algorithm;


public class NumDecodings {
    public static void main(String[] args) {
        int i = NumDecodings.numDecodings("001022");
        System.out.println(i);
    }


    public static int numDecodings(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c=f[i]
        int[] f = new int[n + 1];
        f[0] = 1;
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                // c += b;
                f[i] = f[i - 1];
                // f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                // c += a;
                f[i] += f[i - 2];
            }
            // a = b;
            // b = c;
        }
        //return c;
        return f[n];
    }
}
