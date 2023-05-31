package com.xx.test.algorithm;


public class NumIslands {
    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[][]{{'0','1','0'},{'1','0','1'},{'0','1','0'}};
        System.out.println(numIslands.numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    infect(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    public void infect(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        infect(grid, i + 1, j);
        infect(grid, i - 1, j);
        infect(grid, i, j + 1);
        infect(grid, i, j - 1);
    }
}
