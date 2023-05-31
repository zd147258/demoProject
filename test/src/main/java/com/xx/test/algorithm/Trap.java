package com.xx.test.algorithm;

import java.util.Arrays;

public class Trap {
    public static void main(String[] args) {
        Trap trap = new Trap();
        System.out.println(trap.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
    int result;
    int leftMax = 0;
    public int trap(int[] height) {
        int rightMax = Arrays.stream(height).max().getAsInt();
        for (int i = 0; i < height.length; i++) {
            if (leftMax <= height[i]){
                leftMax = height[i];
            }else{
                result += leftMax - height[i];
            }
            if (height[i] == rightMax){
                leftMax = 0;
                for (int j = height.length - 1; j > i; j--) {
                    if (leftMax <= height[j]){
                        leftMax = height[j];
                    }else{
                        result += leftMax - height[j];
                    }
                }
                break;
            }
        }
        return result;
    }
}
