package com.xx.test.algorithm;

import java.util.Arrays;

public class MinOperations {
    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        System.out.println(minOperations.minOperations(new int[]{6,6}, new int[]{1}));
    }

    int result = 0;
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int n : nums1){
            sum1 += n;
        }
        for (int n : nums2){
            sum2 += n;
        }
        int change1 = (int)Math.floor(Math.abs(sum1 - sum2) / 2);
        int change2 = Math.abs(sum1 - sum2) - change1;
        if (sum1 > sum2){
            reduce(nums1, change1);
            enlarge(nums2, change2);
        }else {
            reduce(nums2, change1);
            enlarge(nums1, change2);
        }
        if (change1 != 0 || change2 != 0){
            result = -1;
        }
        return result;
    }

    public void reduce (int[] nums, int change){
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (change == 0){
                break;
            }
            if (nums[i] == 1){
                continue;
            }
            if ((nums[i] - 1) >= change){
                nums[i] -= change;
                result++;
                break;
            }else {
                change -= nums[i] - 1;
                nums[i] -= nums[i] - 1;
                result++;
            }
        }
    }

    public void enlarge (int[] nums, int change){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (change == 0){
                break;
            }
            if (nums[i] == 6){
                continue;
            }
            if ((6 - nums[i]) >= change){
                nums[i] += change;
                result++;
                break;
            }else {
                change -= 6 - nums[i];
                nums[i] += 6 - nums[i];
                result++;
            }
        }
    }
}
