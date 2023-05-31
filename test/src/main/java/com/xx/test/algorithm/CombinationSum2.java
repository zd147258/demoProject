package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> lists = combinationSum2.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }

    List<List<Integer>> res = new ArrayList<>();
    int sum = 0;
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target);
        return res;
    }

    public void backtrack(int[] candidates, int target){
        if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (list.contains(candidates[i])){
                continue;
            }
            if (sum + candidates[i] <= target){
                list.add(candidates[i]);
                sum+=candidates[i];
                backtrack(candidates, target);
                sum-=candidates[i];
                list.remove(list.size() - 1);
            }
        }
    }
}
