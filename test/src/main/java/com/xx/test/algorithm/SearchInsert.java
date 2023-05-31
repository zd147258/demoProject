package com.xx.test.algorithm;

public class SearchInsert {
    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int i = searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(i);
    }

    int result;

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (low <= high){
            System.out.println("low:" + low + "high:" + high);
            mid = (int) Math.floor((low + high) / 2);
            System.out.println("mid:" + mid);
            if (nums[mid] > target){
                high = mid - 1;
            }else if (nums[mid] < target){
                if (mid == nums.length - 1){
                    return mid + 1;
                }else {
                    if (nums[mid + 1] > target){
                        return mid + 1;
                    }
                }
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return result;
    }
}
