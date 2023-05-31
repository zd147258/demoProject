package com.xx.test.algorithm;

public class Rotate1 {
    public static void main(String[] args) {
        Rotate1 rotate1 = new Rotate1();
        int[] ints = new int[]{1,2,3,4,5,6,7};
        rotate1.rotate(ints, 8);
        for (int n : ints){
            System.out.print(n + ",");
        }
    }
    public void rotate(int[] nums, int k) {
//        k %= nums.length;
//        for (int i = 0; i < k; i++) {
//            int temp = nums[nums.length - 1];
//            for (int j = nums.length - 1; j > 0 ; j--) {
//                nums[j] = nums[j-1];
//            }
//            nums[0] = temp;
//        }
        //-----------------------------
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        System.out.print("第一次翻转：");
        for (int n1 : nums){
            System.out.print(n1 + ",");
        }
        System.out.println();
        reverse(nums, 0, k - 1);
        System.out.print("第二次翻转：");
        for (int n1 : nums){
            System.out.print(n1 + ",");
        }
        System.out.println();
        reverse(nums, k, n - 1);
        System.out.print("第三次翻转：");
        for (int n1 : nums){
            System.out.print(n1 + ",");
        }
        System.out.println();
    }

    /**
     * 翻转
     * @param nums
     * @param start
     * @param end
     */
    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
