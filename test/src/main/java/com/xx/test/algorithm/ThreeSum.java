package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int ans = 0;
    
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        System.out.print("排序：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        callback(nums, 0, 0);
        return result;
    }
    public void callback(int[] nums, int depth, int target){
        if (list.size() == 3 && ans == target){
            result.add(new ArrayList<>(list));
            return;
        }
        //-4 -1 -1 0 1 2
        for (int i = depth; i < nums.length; i++) {
            System.out.println("i:" + i);
            System.out.println("depth" + depth);
            if (list.size() == 3){
                break;
            }
            if (i > depth && nums[i] == nums[i - 1]) {
                System.out.println("=================continue了================");
                continue;
            }
            list.add(nums[i]);
            System.out.println(list);
            ans += nums[i];
            callback(nums, i + 1, target);
            ans -= nums[i];
            list.remove(list.size() - 1);
        }
    }
}
