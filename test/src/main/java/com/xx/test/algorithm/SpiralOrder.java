package com.xx.test.algorithm;

import java.util.LinkedList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        System.out.println(spiralOrder.spiralOrder(new int[][]{{1, 2, 3}, { 4, 5, 6}, {7, 8, 9}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> result = new LinkedList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int step = matrix[0].length * matrix.length;
        while (step >= 1){
            for (int i = left; i <= right && step >= 1; i++) {
                result.add(matrix[top][i]);
                step--;
            }
            top++;
            for (int i = top; i <= bottom && step >= 1; i++) {
                result.add(matrix[i][right]);
                step--;
            }
            right--;
            for (int i = right; i >= left && step >= 1; i--) {
                result.add(matrix[bottom][i]);
                step--;
            }
            bottom--;
            for (int i = bottom; i >= top && step >= 1; i--) {
                result.add(matrix[i][left]);
                step--;
            }
            left++;
        }
        return result;
    }

}
