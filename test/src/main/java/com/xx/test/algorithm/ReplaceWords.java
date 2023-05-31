package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("b");
        dictionary.add("c");
        System.out.println(dictionary);
        String sentence = "aadsfasf absbs bbab cadsfafs";
//        System.out.println(replaceWords.replaceWords(dictionary, sentence));
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dictionarySet = new HashSet<String>();
        for (String root : dictionary) {
            dictionarySet.add(root);
        }
        String[] split = sentence.split(" +");
        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        for (String s : split){
            flag = true;
            for (int i = 0; i < s.length(); i++) {
                String substring = s.substring(0, i);
                System.out.println("subString:" + substring);
                if (dictionarySet.contains(substring)) {
                    sb.append(substring).append(" ");
                    flag = false;
                    break;
                }
            }
            if (flag){
                sb.append(s).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
