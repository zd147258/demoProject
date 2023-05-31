package com.xx.test.algorithm;


public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{3,2,3}));
    }
    public int majorityElement(int[] nums) {
        int count = 1;
        int number = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == number){
                count++;
            }else {
                count--;
                if (count == 0){
                    count = 1;
                    number = nums[i];
                }
            }
        }
        return number;
    }

}
