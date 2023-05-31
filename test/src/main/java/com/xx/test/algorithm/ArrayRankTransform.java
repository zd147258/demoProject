package com.xx.test.algorithm;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ArrayRankTransform {
    public static void main(String[] args) {
        ArrayRankTransform arrayRankTransform = new ArrayRankTransform();
//        int[] ints = arrayRankTransform.arrayRankTransform(new int[]{27,46,-3,-36,31,-14,-7,-36,27,-14,41,-40,23});
//        for (int i = 0; i < ints.length; i++) {
//            System.out.print(ints[i] + ",");
//        }
        String str = "50";
        BigDecimal bigDecimal1 = new BigDecimal(605);
        BigDecimal bigDecimal2 = new BigDecimal(400);
        System.out.println(bigDecimal1.compareTo(bigDecimal2));
        System.out.println(bigDecimal1.subtract(bigDecimal2));
//        BigDecimal bigDecimal2 = new BigDecimal(str);
//        System.out.println(bigDecimal1.add(bigDecimal2));
//        System.out.println(bigDecimal1);
//        bigDecimal1 = bigDecimal1.add(bigDecimal2);
//        System.out.println(bigDecimal1);
    }
    //1:每位+1
    //2:依次和arr[i]比较,比arr[i]大就不管，比arr[i]小,就-1,temp[i]+1
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0){
            return new int[]{};
        }
        int[] temp = new int[arr.length];
        temp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < i ; j++) {
                if (arr[j] == arr[i]){
                    if (temp[j] > 1){
                        temp[j]--;
                    }
                    temp[i] = temp[j];
                    flag = false;
                }
            }
            if (flag){
                for (int j = 0; j <= i; j++) {
                    temp[j]++;
                    if (arr[j] < arr[i]){
                        temp[j]--;
                        temp[i]++;
                    }
                }
            }
        }
        return temp;
    }
}
