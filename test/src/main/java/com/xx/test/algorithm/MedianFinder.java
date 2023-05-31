package com.xx.test.algorithm;

import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        double param_2 = obj.findMedian();
    }

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }

    public void addNum(int num) {
        max.add(num);
        min.add(max.remove());
        if (min.size() > max.size()) {
            max.add(min.remove());
        }
    }

    public double findMedian() {
        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        } else {
            return max.peek();
        }
    }
}
