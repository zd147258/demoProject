package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] ints = singleNumber.singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        for (int n : ints){
            System.out.println(n+",");
        }
    }

    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])){
                list.remove(nums[i]);
            }else {
                list.add(nums[i]);
            }
        }
        result[0] = list.get(0);
        result[1] = list.get(1);
        return result;
    }
}
