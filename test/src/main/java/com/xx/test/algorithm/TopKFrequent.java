package com.xx.test.algorithm;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
//        int[] ints = topKFrequent.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.print(ints[i] + ",");
//        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}
