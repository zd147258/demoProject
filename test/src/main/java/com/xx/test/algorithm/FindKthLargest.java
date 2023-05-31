package com.xx.test.algorithm;

public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, 20));
    }
    public int findKthLargest(int[] nums, int k) {
        for (int j = 0; j < nums.length; j++) {
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums[k - 1];
    }
}
