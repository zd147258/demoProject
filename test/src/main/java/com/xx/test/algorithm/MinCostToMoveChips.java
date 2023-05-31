package com.xx.test.algorithm;

public class MinCostToMoveChips {
    public static void main(String[] args) {
        MinCostToMoveChips minCostToMoveChips = new MinCostToMoveChips();
        System.out.println(minCostToMoveChips.minCostToMoveChips(new int[]{1, 2, 3}));
    }
    public int minCostToMoveChips(int[] position) {
        int count = 0;
        //超出内存限制
/*        int max = position[0];
        for (int i = 0; i < position.length; i++) {
            max = Math.max(max, position[i]);
        }
        int[] dp = new int[max + 1];
        for (int i = 0; i < position.length; i++) {
            dp[position[i]]++;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 0) {
                continue;
            }else {
                if (i + 2 <= dp.length - 1 && dp[i + 2] != 0){
                    dp[i + 2] += dp[i];
                    dp[i] = 0;
                }else {
                    if (i + 1 <= dp.length - 1 && dp[i + 1] != 0){
                        if (dp[i + 1] < dp[i]){
                            dp[i] += dp[i + 1];
                            count += dp[i + 1];
                            dp[i + 1] = 0;
                        }else {
                            dp[i + 1] += dp[i];
                            count += dp[i];
                            dp[i] = 0;
                        }
                    }else {
                        break;
                    }
                }
            }
        }*/
        return count;
    }
}
