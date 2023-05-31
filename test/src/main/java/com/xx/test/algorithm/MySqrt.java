package com.xx.test.algorithm;

public class MySqrt {
    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(2147395600));
    }

    public int mySqrt(int x) {
        if (x <= 1){
            return x;
        }
        long r = x;
        while(r > x/r){
            r = (x/r + 2*r)/3;
        }
        return (int)r;
    }
}
