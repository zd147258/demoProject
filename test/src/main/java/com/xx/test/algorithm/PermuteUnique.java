package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique(new int[]{3,3,0,3}));
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<Integer> list, int[] nums, boolean[] used){
        if (list.size() == nums.length){
            System.out.println("======================"+list);
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            System.out.println("list:" + list);
            used[i] = true;
            backtrack(list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
            System.out.println("list:after:" + list);
        }
    }
}
