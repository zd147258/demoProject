package com.xx.test.algorithm;

public class Solve {
    public static void main(String[] args) {
        Solve  solve = new Solve();
        char[][] board = new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("====================");
        solve.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        char[][] board1 = new char[][]{{'O','X','X','O','X'},{'X','X','X','X','O'},{'X','X','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        System.out.println("====================");
        for (int i = 0; i < board1.length; i++) {
            for (int j = 0; j < board1[0].length; j++) {
                System.out.print(board1[i][j]);
            }
            System.out.println();
        }
    }
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i > 0 && j > 0 && i < board.length - 1 && j < board[0].length - 1 && 'O' == board[i][j]){
                    if (dfs(i ,j ,board)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    public boolean dfs (int i, int j, char[][] board) {
        //上
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        if ('O' == board[i-1][j]){
            System.out.println("===========11===========");
            if (0 == i-1){
                return false;
            }else {
                if (dfs(i-1, j, board)) {
                    board[i][j] = 'X';
                    return true;
                }else {
                    flag1 = false;
                }
            }
        }else {
            System.out.println("i:" + i);
            System.out.println("j:" + j);
            System.out.println("===========12===========");
            flag1 = true;
        }
        //下
        if ('O' == board[i+1][j]){
            System.out.println("===========21===========");
            if (board.length-1 == i+1){
                return false;
            }else {
                if (dfs(i+1, j, board)) {
                    board[i][j] = 'X';
                    return true;
                }else {
                    flag2 = false;
                }
            }
        }else {
            System.out.println("===========22===========");
            flag2 = true;
        }
        //左
        if ('O' == board[i][j-1]){
            if (0 == j-1){
                return false;
            }else {
                if (dfs(i, j-1, board)) {
                    board[i][j] = 'X';
                    return true;
                }else {
                    flag3 = false;
                }
            }
        }else {
            flag3 = true;
        }
        //右
        if ('O' == board[i][j+1]){
            if (board[0].length-1 == i+1){
                return false;
            }else {
                if (dfs(i, j+1, board)) {
                    board[i][j] = 'X';
                    return true;
                }else {
                    flag4 = false;
                }
            }
        }else {
            flag4 = true;
        }
        return flag1 && flag2 && flag3 && flag4;
    }
}
