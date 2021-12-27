package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 标题: Backtracking
 * 说明: //TODO
 * 时间: 2021/12/23 10:25
 * @author 郑冬
 **/
public class Backtracking {
    public static void main(String[] args) {
        Backtracking fourSum = new Backtracking();

        List<List<Integer>> lists = fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        //List<List<Integer>> lists = fourSum.fourSum(new int[]{2, 2, 2, 2, 2, 2}, 8);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

/*        List<List<Integer>> lists = fourSum.combinationSum(3, 9);
        System.out.println(lists);*/

/*        List<List<Integer>> permute = fourSum.permute(new int[]{1, 2, 3});
        System.out.println(permute);*/

    }

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int ans = 0;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        callBack(0, nums, target);
        return lists;
    }

    private void callBack(int index, int[] nums, int target) {
        if (list.size() == 4 && ans == target) {
            lists.add(new ArrayList<>(list));
        }else {
            for (int i = index; i < nums.length; i++) {
                if (i > index && nums[i] == nums[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                ans += nums[i];
                callBack(i + 1, nums, target);
                ans -= nums[i];
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int numsLen = nums.length;
        List<List<Integer>> resList = new ArrayList<>();
        if (numsLen < 4) {
            return resList;
        }
        for (int i = 0; i < numsLen - 3; ++i) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏,直接跳出循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏
            if (nums[i] + nums[numsLen - 1] + nums[numsLen - 2] + nums[numsLen - 3] < target) {
                continue;
            }
            int threeSum = target - nums[i];

            for (int j = i + 1; j < numsLen - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[j] + nums[j + 1] + nums[j + 2] > threeSum) {
                    break;
                }
                if (nums[j] + nums[numsLen - 1] + nums[numsLen - 2] < threeSum) {
                    continue;
                }
                int twoSum = threeSum - nums[j];
                int left = j + 1;
                int right = numsLen - 1;

                while (left < right) {
                    while (left < right && nums[left] + nums[right] < twoSum) {
                        left += 1;
                    }
                    while (left < right && nums[left] + nums[right] > twoSum) {
                        right -= 1;
                    }
                    if (left != right && nums[left] + nums[right] == twoSum) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        resList.add(list);
                        left += 1;
                        // 如果重复继续left+1
                        while (left < right && nums[left] == nums[left - 1]) {
                            left += 1;
                        }
                    }
                }
            }
        }
        return resList;
    }

    public List<List<Integer>> combinationSum(int k, int n){
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
        System.out.println(list);
        //终止条件，如果满足这个条件，再往下找也没什么意义了
        if (list.size() == k || n <= 0) {
            //如果找到一组合适的就把他加入到集合list中
            if (list.size() == k && n == 0){
                res.add(new ArrayList<>(list));
                return;
            }
        }
        //通过循环，分别遍历9个子树
        for (int i = start; i <= 9; i++) {
            //选择当前值
            list.add(i);
            //递归
            dfs(res, list, k, i + 1, n - i);
            //撤销选择
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums){
        //终止条件
        if (list.size() == nums.length){
            //说明找到一一组组合
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //因为不能有重复的，所以有重复的就不能选
            if (list.contains(nums[i])){
                continue;
            }
            //选择当前值
            list.add(nums[i]);
            //递归
            backtrack(res, list, nums);
            //撤销选择
            list.remove(list.size() - 1);
        }
    }
}
