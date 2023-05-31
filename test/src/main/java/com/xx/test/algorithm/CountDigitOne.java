package com.xx.test.algorithm;

public class CountDigitOne {
    public static void main(String[] args) {
        CountDigitOne countDigitOne = new CountDigitOne();
        System.out.println(countDigitOne.countDigitOne(1999));
    }
    //1-15:20-8-4=8
    //1-19:20-8=12
    //1-89:20-1=19
    //1-99:20*10^0=20
    //1-899:300-20=280
    //1-999:20*10^1+100*10^0=300
    //1-1999:4000-300*8=1600
    //1-8999:4000-300=3700
    //1-9999:20*10^2+100*10^1+1000*10^0=4000
    //1-99999:20*10^3+100*10^2+1000*10^1+10000*10^0=50000
    public int countDigitOne(int n) {
        //9,6,4,2,3,5,7,0,1
         if(n==0){
            return 0;
        }
        if(n<10){
            return 1;
        }
        String s= Integer.toString(n);
        int res=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='1'){
                res+=Integer.parseInt((i==0?"":s.substring(0,i))+s.substring(i+1))+1;
            }else if(c>'1'){
                StringBuilder builder=new StringBuilder();
                builder.append(s.substring(0,i));
                int k=i+1;
                while(k<s.length()){
                    builder.append("9");
                    k++;
                }
                res+=Integer.parseInt(builder.toString())+1;
            }else{
                int pre=Integer.parseInt(s.substring(0,i))-1;
                StringBuilder builder=new StringBuilder();
                builder.append(pre);
                int k=i+1;
                while(k<s.length()){
                    builder.append("9");
                    k++;
                }
                res+=Integer.parseInt(builder.toString())+1;
            }
        }
        return res;
    }
}
