package com.xx.test.algorithm;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.xx.test.bo.AccountBO;
import com.xx.test.bo.Bank;
import com.xx.test.bo.OooBO;
import org.springframework.beans.BeanUtils;
import sun.java2d.pipe.SpanIterator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumSubarrayMins {
    /**
     * 调用链表示
     */
    private static final String TRACE_IDENTIFICATION = "TRACE_ID";
    /**
     * 开始标识
     */
    private static final String START_IDENTIFICATION = "START";
    private static int amount = 1;
    /**
     * 线程全局map，线程生命周期内始终存在
     */
    private static final InheritableThreadLocal<Map<String, String>> THREAD_MAP = new InheritableThreadLocal<>();
    public static void main(String[] args) {
//        SumSubarrayMins sumSubarrayMins = new SumSubarrayMins();
//        System.out.println(sumSubarrayMins.sumSubarrayMins(new int[]{3,1,2,4}));
        List<String> tabIdList = Arrays.asList("30023", "30025", "30021");
        if (tabIdList.contains("20026")){
            System.out.println("!");
        }
    }

    private static int dealpreDepositAmount(int num) {
        System.out.println(Thread.currentThread().getName());
        amount -= num;
        if (amount < 0){
            return -1;
        }
        return amount;
    }

    /*
     * 获取当前天的结束时间
     */
    public static Date getEndTime() {
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DAY_OF_YEAR, 365);
//        day.set(Calendar.HOUR_OF_DAY, 23);
//        day.set(Calendar.MINUTE, 59);
//        day.set(Calendar.SECOND, 59);
//        day.set(Calendar.MILLISECOND, 999);
        return day.getTime();
    }
    private static final int MOD = 1000000007;
    public int sumSubarrayMins(int[] arr){
        // 处理边界情况
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        // 每个元素辐射范围的左边界
        int[] left = new int[n];
        // 每个元素辐射范围的右边界
        int[] right = new int[n];
        Deque<Integer> stack = new LinkedList<>();

        // 第一次循环先找到所有元素的左边界
        for (int i = 0; i < n; i++) {
            // 向左找第一个小于等于E的元素
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // 设立一个最左边界-1
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            // 下标入栈，方便同时得到i和A[i]
            stack.push(i);
        }

        // 第二次循环找到所有元素的右边界
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            // 向右找第一个小于E的元素
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // 设立一个最右边界n
            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }
            // 下标入栈，方便同时得到i和A[i]
            stack.push(i);
        }

        // 按照贡献度计算即可
        // 注意此处left[i]和right[i]实际上记录的是左边界-1和右边界+1，和上面思路中有些区别，便于计算
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int)ans;
    }
}