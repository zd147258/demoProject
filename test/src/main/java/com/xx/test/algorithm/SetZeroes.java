package com.xx.test.algorithm;

public class SetZeroes {
    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
        setZeroes.setZeroes(ints);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[1].length; j++) {
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }
    }

    static int[][] ints = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
    public void setZeroes(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == 1){
                    for (int k = 0; k < matrix[0].length; k++) {
                        matrix[i][k] = 0;
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }
}
