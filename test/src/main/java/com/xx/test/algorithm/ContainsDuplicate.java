package com.xx.test.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1, 2, 3, 3}));

    }
    public boolean containsDuplicate(int[] nums) {
        //hashmap
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])){
//                return true;
//            }else {
//                map.put(nums[i], 1);
//            }
//        }
        //hashset
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() != nums.length){
            return true;
        }
        return false;
    }
}
