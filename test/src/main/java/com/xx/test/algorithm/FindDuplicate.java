package com.xx.test.algorithm;

public class FindDuplicate {
    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(new int[]{3,1,3,4,2}));
    }
    public int findDuplicate(int[] nums) {
//        int result = 0;
//        int[] ints = new int[nums.length - 1];
//        for (int i = 0; i < nums.length; i++) {
//            if (ints[nums[i] - 1] == 0){
//                ints[nums[i] - 1] = 1;
//            }else {
//                result = nums[i];
//                break;
//            }
//        }
//        return result;
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
