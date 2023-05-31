package com.xx.test.algorithm;

public class ComputeArea {
    public static void main(String[] args) {
        ComputeArea maximalSquare = new ComputeArea();
        System.out.println(maximalSquare.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int total = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        if (ax2 <= bx1 || bx2 <= ax1 || ay2 <= by1 || by2 <= ay1){
            return total;
        }
        int[] xints = bubbleSort(ax1, ax2, bx1, bx2);
        int[] yints = bubbleSort(ay1, ay2, by1, by2);
        int overlap = (xints[2] - xints[1]) * (yints[2] - yints[1]);
        return total - overlap;
    }

    public static int[] bubbleSort(int a, int b, int c, int d){
        int[] nums = {a, b, c, d};
        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]){
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
        return nums;
    }

}
