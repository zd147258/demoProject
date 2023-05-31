package com.xx.test.algorithm;


public class MaximalRectangle {
    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        maximalRectangle.maximalRectangle(matrix);
    }


    public int maximalRectangle(char[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1){
                    if (matrix[i+1][j] == 1){

                    }
                }
            }
        }
        return result;
    }
}
