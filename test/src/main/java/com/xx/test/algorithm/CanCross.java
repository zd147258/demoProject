package com.xx.test.algorithm;

import java.util.HashMap;
import java.util.Map;

public class CanCross {
    public static void main(String[] args) {
        CanCross canCross = new CanCross();
        System.out.println(canCross.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }

    Map<Integer, Integer> map ; //用于存放对应值的位置
    Map<Integer, Boolean> cache;
    public boolean canCross(int[] stones) {
        map = new HashMap<>();
        cache =new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i],i);
        }
        //默认 第一位置只能跳1个单位
        return dfs(stones,0,1);
    }

    private boolean dfs(int[] stones,int start,int k){
        Integer key = stones[start] * 2000 * 2000 + k;
        if(null != cache.get(key)) {
            return cache.get(key);
        }
        //查找下一个位置是否存在
        int index = map.getOrDefault(stones[start] + k,-1);
        //跳不到 || 回头跳 || 原地跳
        if(index == -1 || index <= start) {
            cache.put(key, false);
            return false;
        }
        // 跳到最后
        if(index == stones.length-1) {
            cache.put(key, true);
            return true;
        }

        // 跳k k-1 k+1 只要任意一个跳到就可以
        boolean b = dfs(stones, index, k + 1) || dfs(stones, index, k) || dfs(stones, index, k - 1);
        cache.put(key,b);
        return b;
    }
}
