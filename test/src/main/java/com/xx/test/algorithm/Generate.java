package com.xx.test.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public static void main(String[] args) {
        Generate generate = new Generate();
        List<List<Integer>> generate1 = generate.generate(5);
        System.out.println(JSON.toJSONString(generate1));
    }
    /*
    *       1
    *      1 1
    *     1 2 1
    *    1 3 3 1
    *   1 4 6 4 1
    * 1 5 10 10 5 1
    * */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows ; i++) {
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    line.add(1);
                }else {
                    line.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(line);
        }
        return result;
    }
}
