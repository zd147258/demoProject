package com.xx.test.algorithm;

import java.util.Arrays;

public class MaximumGap {
    public static void main(String[] args) {
        MaximumGap maximumGap = new MaximumGap();
        System.out.println(maximumGap.maximumGap(new int[]{3, 6, 9, 1}));
    }
    public int maximumGap(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, nums[i] - nums[i - 1]);
        }
        return result;
    }
}
