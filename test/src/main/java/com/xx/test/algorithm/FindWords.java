package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.List;

public class FindWords {
    public static void main(String[] args) {
        FindWords findWords = new FindWords();
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
        findWords.findWords(board, words);
    }
    public List<String> findWords(char[][] board, String[] words) {
        for (int i = 0; i < words.length; i++) {
            String[] split = words[i].split("");
            for (int j = 0; j < split.length; j++) {
                System.out.print(split[j]);
            }
        }
        return new ArrayList<>();
    }
}
