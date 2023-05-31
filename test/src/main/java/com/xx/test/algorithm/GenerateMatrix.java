package com.xx.test.algorithm;

public class GenerateMatrix {
    public static void main(String[] args) {
        GenerateMatrix gm = new GenerateMatrix();
        int[][] ints = gm.generateMatrix(3);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.println(ints[i][j]);
            }
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int val = 1, top = n * n, x = 0, y = 0;
        while (val < top) { // 注意是 < , 因为时刻保持向右或向下时当前所在位置时可填的, 所以最后一个数会不填
            while (y + 1 < n && ans[x][y + 1] == 0) {ans[x][y++] = val++;} // 向右
            while (x + 1 < n && ans[x + 1][y] == 0) {ans[x++][y] = val++;} // 向下
            while (y > 0 && ans[x][y - 1] == 0) {ans[x][y--] = val++;} // 向左
            while (x > 0 && ans[x - 1][y] == 0) {ans[x--][y] = val++;} // 向上
        }
        ans[x][y] = val; // 填上最后一个空位置
        return ans;
    }
}
