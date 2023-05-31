package com.xx.test.algorithm;

import java.util.*;

public class MajorityElement1 {
    public static void main(String[] args) {
        MajorityElement1 majorityElement1 = new MajorityElement1();
        System.out.println(majorityElement1.majorityElement(new int[]{2,2}));
    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        // 定义候选人和计票器
        int h1 = nums[0], count1 = 0;
        int h2 = nums[0], count2 = 0;

        for (int num : nums) {
            // 计数
            if (h1 == num) {
                count1++;
                // 每次匹配玩跳出本轮匹配
                continue;
            }

            // 计数
            if (h2 == num) {
                count2++;
                continue;
            }

            // 匹配新的候选人1
            if (count1 == 0) {
                h1 = num;
                count1++;
                continue;
            }

            // 匹配新的候选人2
            if (count2 == 0) {
                h2 = num;
                count2++;
                continue;
            }

            // 当没有匹配到当前任何候选人 并且当前候选人票数大于1时 进行票数的抵消
            count2--;
            count1--;
        }

        count1 = 0;
        count2 = 0;
        // 重新确认当前选取的候选人 票数是否超过指定票数。
        for (int num : nums) {
            if (h1 == num) {
                count1++; // 这里必须用 else if 确保票都落在同一个人的头上
            } else if (h2 == num) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            list.add(h1);
        }
        if (count2 > nums.length / 3) {
            list.add(h2);
        }

        return list;
    }
}
