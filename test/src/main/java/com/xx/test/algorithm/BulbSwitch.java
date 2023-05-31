package com.xx.test.algorithm;

public class BulbSwitch {
    public static void main(String[] args) {
        BulbSwitch bulbSwitch = new BulbSwitch();
        System.out.println(bulbSwitch.bulbSwitch(3));
    }
    public int bulbSwitch(int n) {
        int[] ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = 1;
        }
        for (int i = 2; i <= n ; i++) {
            for (int j = i - 1; j < ints.length; j+=i) {
                ints[j] = switch1(ints[j]);
            }
        }
        int result = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 1){
                result++;
            }
        }
        return result;
    }

    public int switch1(int a){
        return a == 0 ? 1 : 0;
    }
}
