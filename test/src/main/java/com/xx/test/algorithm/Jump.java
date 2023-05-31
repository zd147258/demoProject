package com.xx.test.algorithm;

public class Jump {
    public static void main(String[] args) {
        Jump jump = new Jump();
        System.out.println(jump.jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }
    int ans = 0;
    int end = 0;
    int maxPos = 0;
    public int jump(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + i > maxPos){
                maxPos = nums[i] + i;
            }
            if (i == end) {
                end = maxPos;
                ans++;
            }
        }
        return ans;
    }
}

