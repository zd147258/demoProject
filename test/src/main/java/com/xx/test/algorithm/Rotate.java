package com.xx.test.algorithm;


public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        Rotate rotate = new Rotate();
        rotate.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.print("]");
        }
    }
    public void rotate(int[][] matrix) {
        double floor = Math.floor(matrix.length / 2);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < floor; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
