package com.xx.test.algorithm;

public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        findPeakElement.findPeakElement(new int[]{});
    }
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]){  //往左边上坡
                right = mid;
            }else{
                left = mid + 1; //往右边上坡
            }
        }
        return left;
    }
}
