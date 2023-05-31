package com.xx.test.algorithm;

public class ClimbStairs {
    public static void main(String[] args) {

    }
    public int climbStairs(int n) {
        if(n <= 2) {return n;}
        int a = 1, b = 2, sum = 0;
        for(int i = 3; i <= n; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;

//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for(int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
    }
}
