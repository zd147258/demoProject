package com.xx.test.algorithm;


public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(maxProfit.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = 100000;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            result = Math.max(result, prices[i] - min);
        }
        return result;
        //超时
/*        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                result = result <  (prices[j] - prices[i]) ? (prices[j] - prices[i]) : result;
            }
        }
        return result;*/
    }
}
