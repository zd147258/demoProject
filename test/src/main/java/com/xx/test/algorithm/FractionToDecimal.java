package com.xx.test.algorithm;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
    public static void main(String[] args) {
        FractionToDecimal fractionToDecimal = new FractionToDecimal();
        System.out.println(fractionToDecimal.fractionToDecimal(4, 333));
    }
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long a = numerator, b = denominator;
        if (a > 0 && b < 0 || a < 0 && b > 0){ sb.append('-');}
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b);
        if (a % b == 0){ return sb.toString();}
        sb.append('.');
        System.out.println("sb:" + sb);
        Map<Long, Integer> map = new HashMap<>();
        while ((a = (a % b) * 10) > 0 && !map.containsKey(a)) {
            System.out.println("a:" + a);
            System.out.println("b:" + b);
            System.out.println("a/b:" + a/b);
            System.out.println("sb.length():" + sb.length());
            map.put(a, sb.length());
            sb.append(a / b);
        }
        if (a == 0){ return sb.toString();}
        return sb.insert(map.get(a).intValue(), '(').append(')').toString();
//        return String.valueOf((double) numerator / (double) denominator);
    }
}
