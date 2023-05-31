package com.xx.test.algorithm;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            List<Integer> asciiList = new ArrayList<>();
            for (int j = 0; j < str.length(); j++) {
                int c1 = str.charAt(j);
                asciiList.add(c1);
            }
            Collections.sort(asciiList);
            System.out.println("asciiList:" + asciiList);
            if (!map.containsKey(asciiList)){
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                result.add(stringList);
                map.put(asciiList, stringList);
            }else {
                List<String> stringList = map.get(asciiList);
                stringList.add(str);
            }
        }
        return result;
    }
}
