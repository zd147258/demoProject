package com.xx.test.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPoints {
    public static void main(String[] args) {
        MaxPoints maxPoints = new MaxPoints();
        int[][] points = new int[][]{{0,1},{0,0}};
        System.out.println(maxPoints.maxPoints(points));
    }
    //求能满足最多点的直线方程
    public int maxPoints(int[][] points) {
        int result = 0;
        if (points.length == 1){
            return 1;
        }
//        int n = points.length;
//        int m = 2;
//        //计算组合数
/*        A（n，m）= n!/（n-m）!
        C（n，m）= n!/m!*（n-m）!
        A(3,2) = 3x2x1/1 = 6
        C(3,2) = 3x2x1/2x1x1 = 3*/
//        int comb = factorial(n) / (factorial(m) * factorial(n - m));
        //直线方程map
        Map<String, List<Integer>> equationMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                double k,b = 0;
                System.out.println("i:"+i+","+"j:"+j);
                double x0 = points[i][0];//1
                double y0 = points[i][1];//1
                double x1 = points[j][0];//3
                double y1 = points[j][1];//2
                System.out.println("x0:"+x0+","+"y0:"+y0);
                System.out.println("x1:"+x1+","+"y1:"+y1);
                k=(y1-y0)/(x1-x0);
                b=y0-k*x0;
                if (equationMap.containsKey(k+":"+b)){
                    if (!equationMap.get(k+":"+b).contains(i)){
                        equationMap.get(k+":"+b).add(i);
                    }
                    if (!equationMap.get(k+":"+b).contains(j)){
                        equationMap.get(k+":"+b).add(j);
                    }
                }else {
                    List<Integer> node = new ArrayList<>();
                    node.add(i);
                    node.add(j);
                    equationMap.put(k+":"+b, node);
                }
            }
        }
        for (Map.Entry<String, List<Integer>> entry : equationMap.entrySet()){
            System.out.println(entry.getKey()+"====>"+entry.getValue());
            result = result < entry.getValue().size() ? entry.getValue().size() : result;
        }
        return result;
    }

    /**
     * 计算阶乘
     * @param num
     * @return
     */
    public static int factorial(int num){
        int count = 1;
        for (int i = 2; i <= num; i++) {
            count *= i;
        }
        return count;
    }
}
