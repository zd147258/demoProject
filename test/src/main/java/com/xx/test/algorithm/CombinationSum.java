package com.xx.test.algorithm;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(lists);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,0, target);
//        int len = candidates.length;
//        List<List<Integer>> res = new ArrayList<>();
//        if (len == 0) {
//            return res;
//        }
//        // 排序是剪枝的前提
//        Arrays.sort(candidates);
//        Deque<Integer> path = new ArrayDeque<>();
//        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    public void backtrack(int[] candidates,int begin, int target){
        if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (sum + candidates[i] <= target){
                sum += candidates[i];
                list.add(candidates[i]);
                backtrack(candidates, i, target);
                sum -= candidates[i];
                list.remove(list.size() - 1);
            }
        }
    }


    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
