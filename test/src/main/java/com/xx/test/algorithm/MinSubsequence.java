package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinSubsequence {
    public static void main(String[] args) {
        MinSubsequence minSubsequence = new MinSubsequence();
        System.out.println(minSubsequence.minSubsequence(new int[]{4, 3, 10, 9, 8}));
    }
    public List<Integer> minSubsequence(int[] nums) {
        int[] Counter = new int[101]; // Max_Value = 100
        int sum = 0;
        for(int i : nums){
            Counter[i]++;
            sum += i;
        }
        sum /= 2;
        int candidateSum = 0;
        List<Integer> ans = new LinkedList<>();
        outside:for(int i = 100; i >= 0; i--){
            while(Counter[i] > 0){
                Counter[i]--;
                ans.add(i);
                candidateSum += i;
                if(candidateSum > sum) {
                    break outside;
                }
            }
        }
        return ans;
    }
}
