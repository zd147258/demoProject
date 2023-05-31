package com.xx.test.algorithm;


import java.util.ArrayList;
import java.util.List;

public class Merge {
    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] ints = merge.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {10, 18}});
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.println(ints[i][j]);
            }
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < intervals.length-1; i++) {
            System.out.println("===i===" + i);
            if (intervals[i][1] >= intervals[i + 1][0]) {
                System.out.println("===i,1===" + intervals[i][1]);
                System.out.println("===i+1,0===" + intervals[i + 1][0]);
                if (intervals[i][1] < intervals[i + 1][1]){
                    System.out.println("===i,1===" + intervals[i][1]);
                    System.out.println("===i+1,1===" + intervals[i + 1][1]);
                    intervals[i][1] = intervals[i + 1][1];
                    System.out.println("===i,1===" + intervals[i][1]);
                    list.add(i + 1);
                }
            }
        }
        return intervals;
    }
}
