package com.xx.test.algorithm;

public class LargestRectangleArea {
    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        int[] heights = new int[]{2,1,2};
        System.out.println(largestRectangleArea.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i > 0 && heights[i] == heights[i - 1]){
                continue;
            }
            int result1 = heights[i];
            int temp1 = i - 1;
            while (temp1 >= 0 && heights[temp1] >= heights[i]){
                result1 += heights[i];
                temp1--;
            }
            int temp2 = i + 1;
            while (temp2 < heights.length && heights[temp2] >= heights[i]){
                result1 += heights[i];
                temp2++;
            }
            result = result1 > result ? result1 : result;
        }
        return result;
    }
}
