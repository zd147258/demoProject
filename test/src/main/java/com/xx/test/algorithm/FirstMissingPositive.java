package com.xx.test.algorithm;

import java.util.*;


public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int i = firstMissingPositive.firstMissingPositive(new int[]{3,4,-1,1});
        System.out.println(i);
    }

    int result;

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        int number = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number){
                number++;
                continue;
            }
        }
        return result = number;
    }
}

