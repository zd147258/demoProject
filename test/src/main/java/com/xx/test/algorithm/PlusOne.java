package com.xx.test.algorithm;


public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] ints = plusOne.plusOne(new int[]{9,9});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }
    public int[] plusOne(int[] digits) {
        for (int i = 1; i < digits.length + 1; i++) {
            if (digits[digits.length - i] == 9){
                digits[digits.length - i] = 0;
                if (digits.length - (i + 1) < 0){
                    int [] newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    return newDigits;
                }else {
                    continue;
                }
            }else {
                ++digits[digits.length - i];
                break;
            }
        }
        return digits;
    }
}
