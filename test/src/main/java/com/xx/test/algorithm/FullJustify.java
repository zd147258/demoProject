package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {
    public static void main(String[] args) {
        FullJustify fullJustify = new FullJustify();
        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        System.out.println(fullJustify.fullJustify(words, 16));
    }

    int count = 0;

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        while (count < words.length){
            String line = line(words, maxWidth, count);
            System.out.println(line + "==>" + line.length());
            result.add(line);
        }
        return result;
    }

    public String line(String[] words, int maxWidth, int start){
        int wordLenth = 0;
        int number = 0;
        while (count < words.length && wordLenth + words[count].length() <= maxWidth){
            wordLenth += words[count].length();
            count++;
            number++;
            wordLenth++;
        }
        number--;
        wordLenth--;
        StringBuffer sb = new StringBuffer();
        double ceil = Math.ceil((maxWidth - wordLenth) / (number == 0 ? 1 : number));
        int remainder = (maxWidth - wordLenth) % (number == 0 ? 1 : number);
        if (count < words.length){
            for (int i = start; i <= start + number; i++) {
                sb.append(words[i]);
                if (i < start + (number == 0 ? 1 : number)){
                    for (int j = 0; j <= (number == 0 ? ceil - 1 : ceil); j++) {
                        sb.append(" ");
                        if (remainder > 0){
                            sb.append(" ");
                            remainder--;
                        }
                    }
                }
            }
        }else {
            for (int i = start; i <= start + number; i++) {
                sb.append(words[i]);
                if (i < start + number){
                    sb.append(" ");
                }
            }
            for (int i = 0; i < (maxWidth - wordLenth); i++) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
