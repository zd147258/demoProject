package com.xx.test.algorithm;


import java.util.ArrayList;
import java.util.List;

public class Insert {
    public static void main(String[] args) {
        Insert insert = new Insert();
        int[][] insert1 = insert.insert(new int[][]{{1,5}}, new int[]{2, 3});
        for (int i = 0; i < insert1.length; i++) {
            System.out.print("[");
            for (int j = 0; j < 2; j++) {
                System.out.print(insert1[i][j]+",");
            }
            System.out.print("],");
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length==0) {
            List<int[]> list=new ArrayList<int[]>();
            list.add(newInterval);
            return list.toArray(new int[list.size()][]);
        }
        int n0 = 0;
        int n1 = 0;
        int index0 = 0;
        int index1 = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (n0 == 0){
                if (newInterval[0] <= intervals[i][0]){
                    n0 = newInterval[0];
                    index0 = i;
                }else if (intervals[i][0] <= newInterval[0] && newInterval[0] <= intervals[i][1]){
                    n0 = intervals[i][0];
                    index0 = i;
                }else if (intervals[i][1] <= newInterval[0]){
                    if (i == intervals.length - 1){
                        n0 = newInterval[0];
                        index0 = i;
                    }
                }
            }
            if (n0 != 0){
                if (newInterval[1] <  intervals[i][0]){
                    n1 = newInterval[1];
                    index1 = i - 1;
                }else if (intervals[i][0] <= newInterval[1] && newInterval[1] <= intervals[i][1]){
                    n1 = intervals[i][1];
                    index1 = i;
                }else if (intervals[i][1] <= newInterval[1]){
                    if (i == intervals.length - 1){
                        n1 = newInterval[1];
                        index1 = i;
                    }
                }
            }
            if (n0 != 0 && n1 != 0){
                break;
            }
        }
        System.out.println("n0:"+n0);
        System.out.println("n1:"+n1);
        System.out.println("index0:"+index0);
        System.out.println("index1:"+index1);
        int intsLen = 0;
        if (intervals.length - 1 == index0){
            intsLen = intervals.length + 1;
        }else {
            intsLen = intervals.length - (index1 - index0);
        }
        int[][] ints = new int[intsLen][2];
        System.out.println("intsLen:" + intsLen);
        System.out.println(intervals.length - (index1 - index0));
        for (int i = 0; i <= index0; i++) {
            ints[i] = intervals[i];
        }
        if (intervals.length - 1 == index0){
            ints[index0 + 1][0] = n0;
            ints[index0 + 1][1] = n1;
        }else {
            ints[index0][0] = n0;
            ints[index0][1] = n1;
        }
        int count = index0 + 1;
        for (int i = index1 + 1; i < intervals.length; i++) {
            ints[count]= intervals[i];
            count++;
        }
        return ints;
    }

}
