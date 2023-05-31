package com.xx.test.algorithm;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class CanFinish {
    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        canFinish.canFinish(2, new int[][]{{1,2},{2,3},{3,1}});
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        Random random = new Random();
        while (hashSet1.size() < 5){
            hashSet1.add(random.nextInt(35) + 1);
        }
        while (hashSet2.size() < 2){
            hashSet2.add(random.nextInt(11) + 1);
        }
        System.out.println(hashSet1 +","+ hashSet2);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        int[] dp = new int[prerequisites.length];
        for (int i = 0; i < prerequisites.length; i++) {
            dp[i] = 1;
//            dfs(prerequisites, prerequisites[i][0], prerequisites[i][1]);

        }
        return true;
    }

//    public void dfs(int[][] prerequisites,int origin, int target){
//        for (int i = 0; i < prerequisites.length; i++) {
//            if (prerequisites[i][0] == target) {
//                if (prerequisites[i][1] == origin) {
//
//                }else {
//                    dfs(prerequisites, prerequisites[i][0], prerequisites[i][1]);
//                }
//            }
//        }
//    }
}
