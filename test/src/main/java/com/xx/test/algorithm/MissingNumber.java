package com.xx.test.algorithm;

public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
    public int missingNumber(int[] nums) {
        int[] ints = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]] = nums[i];
        }
        for (int i = 0; i < ints.length; i++) {
            if (i != 0 && ints[i] == 0){
                return i;
            }
        }
        return 0;

//        int res = nums.length;
//        for (int i = 0; i < nums.length; ++i){
//            res ^= nums[i];
//            res ^= i;
//        }
//        return res;
    }
}
