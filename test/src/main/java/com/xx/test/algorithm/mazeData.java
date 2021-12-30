package com.xx.test.algorithm;


public class mazeData {

    public static void main(String[] args) {
        mazeData mazeData = new mazeData();
        mazeData.findExit(data);
    }

    // 迷宫数据  0=空位，1=入口，2=出口，8=障碍物
    public static int [][] data = {
            {1, 8, 0, 0, 0},
            {0, 8, 0, 8, 0},
            {0, 0, 0, 8, 0},
            {0, 8, 0, 8, 0},
            {0, 8, 0, 0, 2}
    };

    public final int STONE = 8;
    public final int ENDPOINT = 2;
    public int startX, startY;

    public int[][] direct = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    // 迷宫的横纵坐标边界
    private int xMax = 0;
    private int yMax = 0;
    private int[][] walked = null;

    // 定义变量记录走出迷宫最少的步数
    private int stepMin = 9999999;

    // 对外暴露的查找出口的方法
    public void findExit(int[][] datas) {
        findStartPos(datas);
        xMax = datas[0].length;
        yMax = datas.length;
        walked = new int[yMax][xMax];
        walked[startX][startY] = 1;
        findExitDFS(datas, startX, startY, 1);
        System.out.println("走出迷宫所需要的最短路径是 " + stepMin + "步");
    }

    // 深度优先
    private void findExitDFS(int[][] datas, int xCur, int yCur, int step) {

        // 循环向每个方向移动一次
        for (int i = 0; i < direct.length; i++) {
            //i=0: direct[0][0]=1, direct[0][1]=0
            //i=1: direct[1][0]=-1, direct[1][1]=0
            //i=2: direct[2][0]=0, direct[2][1]=-1
            //i=3: direct[3][0]=0, direct[3][1]=1
            int xNew = xCur + direct[i][0];
            int yNew = yCur + direct[i][1];
            // 确定是否走出边界
            if(xNew >= xMax || yNew >= yMax || xNew < 0 || yNew <0) {
                continue;
            }
            // 确定是否走过
            if(walked[yNew][xNew] == 1) {
                continue;
            }
            // 确认是否为石头
            if(datas[yNew][xNew] == STONE) {
                continue;
            }
            // 确认到达终点以及记录最小步数
            if(datas[yNew][xNew] == ENDPOINT) {
                if(step < stepMin) {
                    stepMin = step;
                }
                System.out.println("********  找到出口，坐标是：" +xNew + ","
                        + yNew + " 共走了 " + step + "步");
                return;
            }
            System.out.println("移动到了 " + xNew + "," + yNew + "此位置初值是：" + datas[yNew][xNew]);
            walked[yNew][xNew] = 1;
            findExitDFS(datas, xNew, yNew, step + 1);
        }
    }

    // 找到起点坐标
    public void findStartPos(int[][] datas) {
        for (int y = 0; y < datas.length; y++) {
            for (int x = 0; x < datas[y].length; x++) {
                if(datas[y][x] == 1) {
                    startX = x;
                    startY = y;
                    System.out.println("起点坐标：" + startX + "," + startY);
                    return;
                }
            }
        }
    }
}
