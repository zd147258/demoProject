package com.xx.test.algorithm;


public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates.removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2]){
                System.out.println("i:"+i);
                nums[i++] = n;
            }
        }
        return i;
    }
}
