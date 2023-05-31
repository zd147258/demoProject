package com.xx.test.algorithm;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
    public String largestNumber(int[] nums) {
        String result = Arrays.stream(nums).mapToObj(Integer::toString).sorted((o2, o1) -> (o1 + o2).compareTo(o2 + o1)).reduce((o1, o2) -> o1 + o2).get();
        return result.length() > 1 && result.charAt(0) == '0' ? "0" : result;
    }
}
