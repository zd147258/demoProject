package com.xx.test.algorithm;


public class mazeData {
    // 迷宫数据  0=空位，1=入口，2=出口，8=障碍物
    public static int [][] data = {
            {1, 8, 0, 0, 0},
            {0, 8, 0, 8, 0},
            {0, 0, 0, 8, 0},
            {0, 8, 0, 8, 0},
            {0, 8, 0, 0, 2}
    };

    public static void main(String[] args) {
       mazeData mazeData = new mazeData();
        int result = mazeData.mazeData(data);
        System.out.println(result);
    }

    int step = 0;
    //横坐标
    int abscissa = 0;
    //纵坐标
    int ordinate = 0;

    public int mazeData(int[][] mazeData){
        backtracking(mazeData);
        return step;
    }

    public void backtracking(int[][] mazeData){
        for (int i = ordinate; i < mazeData.length; i++) {
            System.out.println(mazeData[i][abscissa] + "x:" + abscissa + "," + "y:" + i);
            step++;
            if (mazeData[i][abscissa + 1] == 0){
                abscissa++;
                ordinate = i;
                backtracking(mazeData);
                break;
            }
        }
    }
}
