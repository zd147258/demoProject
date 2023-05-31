package com.xx.test.algorithm;

public class MaxProfit1 {
    public static void main(String[] args) {
        MaxProfit1 maxProfit1 = new MaxProfit1();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit1.maxProfit(prices));
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
