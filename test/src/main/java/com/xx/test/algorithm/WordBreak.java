package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak.wordBreak(s, wordDict));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // memo[i] 表示 s 中索引为 [0,  i - 1] 范围的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // [0, i] 的字符串可被拆分，当前仅当任一子串 [0, j] 及 [j, i] 可被拆分
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }
}
