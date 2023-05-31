package com.xx.test.algorithm;

public class HIndex {
    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.hIndex(new int[]{1,1}));
    }
    public int hIndex(int[] citations) {
        if (citations.length == 1){
            if (citations[0] == 0){
                return 0;
            }else {
                return 1;
            }
        }
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            max = Math.max(max, citations[i]);
        }
        int mid = max/2;
        int count = 0;
        while (true){
            for (int i = 0; i < citations.length; i++) {
                if (mid <= citations[i] && citations[i] != 0){
                    count++;
                }
            }
            if (mid == 0){
                return count;
            }
            if (count < mid){
                count = 0;
                mid--;
            }else {
                return mid;
            }
        }
    }
}
