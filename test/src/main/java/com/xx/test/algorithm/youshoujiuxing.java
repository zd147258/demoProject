package com.xx.test.algorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class youshoujiuxing {
    public static void main(String[] args) {
        youshoujiuxing aa = new youshoujiuxing();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("a", "aa");
        map.put("b", null);
        map.put("c", null);
        map.put("d", null);
        map.put("e", null);
        map.put("f", null);
        map.put("g", null);
        list.add(map);
        aa.shabi(list);
        for (Map<String, Object> m : list){
            for (Map.Entry<String, Object> a : m.entrySet()) {
                System.out.println(a.getKey()+":"+a.getValue());
            }
        }
    }
    //入参一个List<Map<String, Object>>，需要你筛选里面map值为null的然后替换为特定的字符返回
    public List<Map<String, Object>> shabi(List<Map<String, Object>> list){
        //1
        List<Map<String, Object>> collect = list.stream().filter(item -> item.containsValue(null)).collect(Collectors.toList());
        for (Map<String, Object> map : collect){
            for (Map.Entry<String, Object> m : map.entrySet()) {
                if (null == m.getValue()){
                    map.put(m.getKey(), "指定字符串");
                }
            }
        }
        return list;
    }

    public String addPercent(String s1, String s2) {
        String decimal1 = s1.substring(0, s1.indexOf("%"));
        String decimal2 = s2.substring(0, s2.indexOf("%"));
        BigDecimal bigDecimal1 = new BigDecimal(decimal1);
        BigDecimal bigDecimal2 = new BigDecimal(decimal2);
        BigDecimal bigDecimal = bigDecimal1.add(bigDecimal2);
        return bigDecimal + "%";
    }
}
