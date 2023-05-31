package com.xx.test.algorithm;

public class NumPairsDivisibleBy60 {
    public static void main(String[] args) {
        NumPairsDivisibleBy60 npdb = new NumPairsDivisibleBy60();
//        System.out.println(npdb.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println(20%60);
        System.out.println(100%60);
    }
    /*
    (a + b) % 60 = 0
    => (a % 60 + b % 60) % 60 = 0
    比如 20 和 100， (a + b) % 60 = 120 % 60 = 0
    可转换成 (20 % 60 + 100 % 60) = (20 + 40) % 60 = 0

    使用一个数组 记录 % 60 各个结果的个数
    */
    public int numPairsDivisibleBy60(int[] time) {
        int[] dp = new int[60];
        int res = 0;
        for(int num : time){
            // % 60 是因为可能 t = 60, mod = 60 % 60 = 0,然后 (60 - mod) = 60，因此需要 % 60，直接存放到 0 号 位置
            num %= 60;
            res += dp[(60 - num) % 60];
            dp[num]++;
        }
        return res;
    }
}
