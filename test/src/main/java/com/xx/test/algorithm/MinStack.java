package com.xx.test.algorithm;

import lombok.val;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private List<Integer> list;
    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        list.add(val);
//        Collections.reverse(list);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
//        int min = -9999999;
//        for(int i : list){
//            min = Math.min(i, min);
//        }
        return 0;
    }
}
