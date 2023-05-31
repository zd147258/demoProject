package com.xx.test.algorithm;


public class IsNumber {
    public static void main(String[] args) {
        IsNumber isNumber = new IsNumber();
        System.out.println(isNumber.isNumber("0e"));
    }

    public boolean isNumber(String s) {
        boolean isDecimal = checkDecimal(s);
        System.out.println("isDecimal:" + isDecimal);
        if (!isDecimal){
            boolean isInteger = checkInteger(s);
            System.out.println("isInteger:" + isInteger);
            if (!isInteger){
                return false;
            }
        }
        return true;
    }

    public boolean checkDecimal(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && i < chars.length -1 && chars[i] == '.'){
                if (checkNumber(chars[i-1])){
                    return true;
                }else {
                    if (checkNumber(chars[i+1])){
                        return true;
                    }else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkInteger(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (checkNumber(chars[i])){
                if (i > 0){
                    if (checkE(chars[i-1])) {
                        continue;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean checkNumber(char s){
        char[] chars = {'0','1','2','3','4','5','6','7','8','9'};
        for (char a : chars){
            if (a == s){
                return true;
            }
        }
        return false;
    }

    public boolean checkE(char s){
        if (s == 'e' || s == 'E'){
            return true;
        }
        return false;
    }
}
