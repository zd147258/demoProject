package com.xx.test.algorithm;


public class CanJump {
    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    /**
     * 是否能够避开所有的0
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int furthestIdx = 0;
        for (int i = 0; i <= furthestIdx && furthestIdx < nums.length; i++) {
            // 第一个条件是为了试探有结果，如果没有结果会提前结束，第二个条件是为了防止数组越界。
            furthestIdx = Math.max(furthestIdx, i + nums[i]);
        }
        return furthestIdx >= nums.length - 1;
    }
}
