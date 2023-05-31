package com.xx.test.algorithm;

public class MaxProfit2 {
    public static void main(String[] args) {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit2.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i+1]){
                result += prices[i+1] - prices[i];
            }
        }
        return result;
    }
}
