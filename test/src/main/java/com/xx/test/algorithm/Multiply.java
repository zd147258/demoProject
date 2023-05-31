package com.xx.test.algorithm;


public class Multiply {
    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println(multiply.multiply("123", "456"));
    }
    //100个400 + 100个50 + 100个6 = 40000+5000+600 = 45600
    //20个400 + 20个50 + 20个6 = 8000+1000+120 = 9120
    //3个400 + 3个50 + 3个6= 1200+150+18 = 1368
    StringBuffer sb1 = new StringBuffer();
    StringBuffer sb2 = new StringBuffer();
    String s = "";
    int num = 0;
    public String multiply(String num1, String num2) {
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {

                System.out.println("i:"+i+",j:"+j+",sum:"+Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j)));
                sb2.append(Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j)));
                for (int k = 0; k < (num1.length() - (i + 1)) + (num2.length() - (j + 1)); k++) {
                    sb2.append("0");
                }
                if (sb1.length() > 0){
                    System.out.println("==========sb2:" + sb2.length());
                    for (int k = 1; k < sb2.length(); k++) {
                        System.out.println("=========="+k);
                        int num = 0;
                        if ((sb1.charAt(sb1.length() - k) + sb2.charAt(sb2.length() - k) + num) > 10) {
                            s = String.valueOf(sb1.charAt(sb1.length() - k) + sb2.charAt(sb2.length() - k) + num);
                            num = Integer.valueOf(s.substring(0, 1)).intValue();
                            sb1.replace(sb1.length() - k, sb1.length() - k, s.substring(s.length() - 1, s.length()));
                        }
                    }
                }else {
                    sb1 = sb2;
                }
                System.out.println(sb2);
                sb2.delete(0, sb2.length());
            }
        }
        return String.valueOf('2');
    }
}
