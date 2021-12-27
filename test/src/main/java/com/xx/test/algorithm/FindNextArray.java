package com.xx.test.algorithm;

import java.util.Arrays;

/**
 * 获取下一个排列
 */
public class FindNextArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,5,7,3,1};
        int replace = 0, top = 0;// replace 记录要交换的元素, top 相当于一个小峰值
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                replace = i - 1;
                top = i;
                break;
            }
        }
        System.out.println("replace:" + replace);
        System.out.println("top:" + top);
        //循环遍历输出数组中的每一个元素
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        int temp = nums[replace];
        nums[replace] = nums[replace + 1];
        nums[replace + 1] = temp;
//        for (int i = nums.length - 1; i > replace; i--) {
//            if (nums[i] > nums[replace]) {
//                int temp = nums[replace];
//                nums[replace] = nums[i];
//                nums[i] = temp;
//                break;
//            }
//        }
        //循环遍历输出数组中的每一个元素
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        //1,2,4,3
        if (top == 0) {// 若 top 为初始值 0 , 说明为最大排列, 直接从小到大排序数组
            Arrays.sort(nums);
        } else {
            //对数组a的下标从fromIndex到toIndex-1的元素排序，注意：下标为toIndex的元素不参与排序哦！
            Arrays.sort(nums, top, nums.length);
        }
        //循环遍历输出数组中的每一个元素
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
