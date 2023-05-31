package com.xx.test.algorithm;

public class MyPow {
    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(2.00000, 10));
    }
    public double myPow(double x, int n) {
        if(x == 0.0f){
            return 0.0d;
        }
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
