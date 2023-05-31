package com.xx.test.algorithm;

public class ConvertToTitle {
    public static void main(String[] args) {
        ConvertToTitle convertToTitle = new ConvertToTitle();
        System.out.println(convertToTitle.convertToTitle(2147483647));
    }
    public String convertToTitle(int columnNumber) {
        String result = "";
        while(columnNumber>0)
        {
            int current = (columnNumber - 1) % 26;
            columnNumber = (columnNumber - 1) / 26;
            char character;
            character = (char) ('A'+ current);
            result = character + result;
        }
        return result;
    }

    /**
     * 求对数函数
     * @param b
     * @param a
     * @return
     * logeb/logea = logab
     */
    static double getlog(int b,int a){
        return Math.log(b)/Math.log(a);
    }
}
