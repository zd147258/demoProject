package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvantageCount {
    public static void main(String[] args) {
        AdvantageCount advantageCount = new AdvantageCount();
//        int[] ints = advantageCount.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11});
//        for (int i = 0; i < ints.length; i++) {
//            System.out.print(ints[i] + ",");
//        }
    }

    List list = new ArrayList();
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        for (int n : nums1){
            list.add(n);
        }
        int[] ints = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            int num = m1(list, nums2[i]);
            ints[i] = num;
        }
        return ints;
//        int n = nums1.length;
//        int[][] index = new int[n][2];
//        for(int i = 0; i < n; i++) {
//            index[i][0] = nums2[i];
//            index[i][1] = i;
//        }
//        Arrays.sort(nums1);
//        Arrays.sort(index, (a, b) -> b[0] - a[0]);
//        int left = 0, right = n - 1;
//        for(int i = 0; i < n; i++) {
//            if(nums1[right] > index[i][0]) {
//                nums2[index[i][1]] = nums1[right];
//                right--;
//            } else {
//                nums2[index[i][1]] = nums1[left];
//                left++;
//            }
//        }
//        return nums2;
    }

    public int m1 (List<Integer> list, int num){
        int result = list.get(0);
        if (list.get(list.size() - 1) <= num){
            list.remove(0);
            return result;
        }
        for (int i = list.size() - 1; i > 0 ; i--) {
            if (list.get(i - 1) <= num){
                result = list.get(i);
                list.remove(i);
                return result;
            }
        }
        list.remove(0);
        return result;
    }
}
