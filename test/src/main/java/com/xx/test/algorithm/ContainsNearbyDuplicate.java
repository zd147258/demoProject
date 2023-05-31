package com.xx.test.algorithm;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        ContainsNearbyDuplicate containsNearbyDuplicate = new ContainsNearbyDuplicate();
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate(new int[]{1,2,3,4,5,6,7,8,9,10}, 15));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= k){
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])){
                    return true;
                }else {
                    map.put(nums[i], 1);
                }
            }
            return false;
        }
        for (int i = 0; i < nums.length - k; i++) {
            int num = nums[i];
            for (int j = i + 1; j < i + 1 + k; j++) {
                if (nums[j] == num){
                    return true;
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - k; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                return true;
            }else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }
}
