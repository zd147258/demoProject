package com.xx.test.algorithm;

public class IsHappy {
    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        System.out.println(isHappy.isHappy(19));
    }

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        } while (slow != fast);
        if (fast == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int squareSum(int m) {
        int squaresum = 0;
        while (m != 0) {
            squaresum += (m % 10) * (m % 10);
            m /= 10;
        }
        return squaresum;
    }
}
