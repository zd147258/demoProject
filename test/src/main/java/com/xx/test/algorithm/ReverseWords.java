package com.xx.test.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("a good   example"));
    }
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        StringBuffer sb = new StringBuffer();
        for (int i = words.length - 1; i >= 0 ; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
//        Collections.reverse(Arrays.asList(words));
//        String.join(" ", words);
        return sb.toString();
    }
}
