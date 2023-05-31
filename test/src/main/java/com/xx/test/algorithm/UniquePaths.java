package com.xx.test.algorithm;

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 2));
    }
    public int uniquePaths(int m, int n) {
        return numsCal(m-1+n-1,Math.min(m-1,n-1));
    }

    //数列里的C x 取 y
    private int numsCal(int x,int y){
        double ans = 1;
        while (y > 0){
            ans *= x * 1.0/y;
            x--;
            y--;
        }
        return (int)(ans + 0.5); //四舍五入
    }

    public int uniquePaths1(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

}
