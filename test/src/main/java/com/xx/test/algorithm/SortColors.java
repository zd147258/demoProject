package com.xx.test.algorithm;

public class SortColors {
    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }
    //2,0,2,1,1,0
    //0,2,2,1,1,0
    //0,2,1,2,1,0
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int num = i;
            while (num >= 0 && nums[num+1] < nums[num]){
                int temp = nums[num+1];
                nums[num+1] = nums[num];
                nums[num] = temp;
                num--;
            }
        }
    }
}
