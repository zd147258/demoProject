package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> lists = permute.permute(new int[]{1, 1, 2});
        System.out.println(lists);
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        backtrack(nums, new ArrayList<>(), used);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> list, int[] used){
        if (list.size() == nums.length){
            System.out.println("===============list:" + list);
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1){
                continue;
            }
            list.add(nums[i]);
            used[i] = 1;
            System.out.println("list:" + list);
            backtrack(nums, list, used);
            used[i] = 0;
            list.remove(list.size() - 1);
            System.out.println("list:after:" + list);
        }
    }
}
