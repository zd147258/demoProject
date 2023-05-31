package com.xx.test.algorithm;

import java.util.*;

public class MaxEnvelopes {
    public static void main(String[] args) {
        MaxEnvelopes maxEnvelopes = new MaxEnvelopes();
        System.out.println(maxEnvelopes.maxEnvelopes(new int[][]{{1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 4}, {9, 5}}));
    }
    //[2,3] => [5,4] => [6,7]
    //[6,7] => [6,4] => [5,4] => [2,3]
    //[9,5] => [8,4] => [1,3]
    public int maxEnvelopes(int[][] envelopes) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            int[] envelope = envelopes[i];
            list.add(envelope);
        }
        for (int[] ints : list){
            System.out.println(ints[0]+","+ints[1]);
        }
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] == envelopes[j][0] || envelopes[i][1] == envelopes[j][1]){
                    list.remove(envelopes[i]);
                    continue;
                }
            }
        }
        for (int[] ints : list){
            System.out.println(ints[0]+","+ints[1]);
        }
        return list.size();
    }
}
