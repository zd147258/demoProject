package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.List;

public class GetSkyline {
    public static void main(String[] args) {
        GetSkyline getSkyline = new GetSkyline();
        System.out.println(getSkyline.getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}));
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(buildings[0][0]);
        list.add(buildings[0][2]);
        result.add(list);
        for (int i = 1; i < buildings.length; i++) {
            if (buildings[i][2] == buildings[i - 1][2] && buildings[i][0] <= buildings[i - 1][1]){
                continue;
            }
        }
        return result;
    }
}
