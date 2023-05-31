package com.xx.test.algorithm;

public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(6, new int[]{10,2,3}));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int result = 9999999;
        for (int i = 0; i < nums.length; i++) {
            int count = nums[i];
            if (count > target){
                result = count;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (count == target || nums[j] == target){
                    return 1;
                }
                count += nums[j];
                if (count >= target){
                    result = Math.min(result, j - i + 1);
                    break;
                }
            }
        }
        if (result == 9999999){
            result = 0;
        }
        return result;
    }
}
