package com.xx.test.algorithm;

public class Merge1 {
    public static void main(String[] args) {
        Merge1 merge1 = new Merge1();
        int[] nums1 = new int[]{-1,-1,0,0,0,0};
        int[] nums2 = new int[]{-1,0};
        merge1.merge(nums1, 4, nums2, 2);
        System.out.print("后：");
        for (int n : nums1){
            System.out.print(n + ",");
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - 1; i >= 0 ; i--) {
            if (nums2.length - (nums1.length - i) >= 0 && nums1[i] == 0){
                nums1[i] = nums2[nums2.length - (nums1.length - i)];
            }else {
                break;
            }
        }
        for (int i = 0; i < nums1.length - 1; i++) {
            int num = i;
            while (num >= 0 && nums1[num + 1] < nums1[num]){
                int temp = nums1[num + 1];
                nums1[num + 1] = nums1[num];
                nums1[num] = temp;
                num--;
            }
        }
    }
}
