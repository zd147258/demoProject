package com.xx.test.algorithm;

import java.util.HashMap;
import java.util.Map;

public class GetHint {
    public static void main(String[] args) {
        GetHint getHint = new GetHint();
//        getHint.getHint("1123","0111");
        String str = "100001_6010";
        String[] s = str.split("_");
        if (s.length == 2){
            System.out.println(s[0]);
            System.out.println(s[1]);
            System.out.println(Long.valueOf(s[0]));
        }
    }
    //1A1B
    public String getHint(String secret, String guess) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            int a = 0;
            int b = 0;
            if (secret.charAt(i) == guess.charAt(i)){
                a++;
            }
            if (map.containsKey(secret.charAt(i))){
                map.put(Integer.parseInt(String.valueOf(secret.charAt(i))), map.get(secret.charAt(i)) + 1);
            }else {
                map.put(Integer.parseInt(String.valueOf(secret.charAt(i))), 1);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            if (map.containsKey(guess.charAt(i))){

            }
        }
        return "ss";
    }
}
