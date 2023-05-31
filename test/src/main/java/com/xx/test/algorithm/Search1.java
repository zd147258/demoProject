package com.xx.test.algorithm;

public class Search1 {
    public static void main(String[] args) {
        Search1 search1 = new Search1();
        int[] nums = new int[]{2,5,6,0,0,1,2};
        System.out.println(search1.search(nums, 7));
    }
    public boolean search(int[] nums, int target) {
        for (int n : nums){
            if (n == target){
                return true;
            }
        }
        return false;
    }
}
