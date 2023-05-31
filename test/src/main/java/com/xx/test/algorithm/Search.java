package com.xx.test.algorithm;

import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        Search search = new Search();
        int search1 = search.search(new int[]{1,3}, 1);
        System.out.println(search1);
    }

    int result = -1;


    public int search(int[] nums, int target) {
        //获取数组最大值
        //System.out.println(Arrays.stream(nums).max().getAsInt());
        int low = 0;
        int high = nums.length-1;
        if (high == 0){
            if (target == nums[high]){
                return high;
            }else {
                return result;
            }
        }
        if (target > nums[high] && target < nums[0]){
            return result;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]){
                if (nums[i] < target){
                    return result;
                }else if (nums[i] > target){
                    if (nums[nums.length -1] > target){
                        //后半段找
                        low = i;
                        while (i <= high){
                            int mid = (int)Math.floor((high + low) / 2);
                            if(target == nums[mid]){
                                return mid;
                            }else if(target > nums[mid]){
                                low=mid + 1;
                            }else{
                                high=mid - 1;
                            }
                        }
                    }else if (nums[nums.length -1] < target){
                        //前半段找
                        high = i;
                        while (low <= i){
                            int mid = (int)Math.floor((low + high) / 2);
                            if(target == nums[mid]){
                                return mid;
                            }else if(target > nums[mid]){
                                low=mid + 1;
                            }else{
                                high=mid - 1;
                            }
                        }
                    }else {
                        return nums.length -1;
                    }
                }else {
                    return i;
                }
                break;
            }
        }
        return result;
    }
}
