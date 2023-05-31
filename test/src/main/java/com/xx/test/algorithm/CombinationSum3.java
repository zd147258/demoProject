package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3  combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.combinationSum3(9, 45));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                for (int l = j + 1; l < 10; l++) {
                    if (i + j + l == n){
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        list.add(l);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
}
