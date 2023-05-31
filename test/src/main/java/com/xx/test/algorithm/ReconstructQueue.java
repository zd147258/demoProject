package com.xx.test.algorithm;

import java.util.Calendar;
import java.util.Date;

public class ReconstructQueue {
    public static void main(String[] args) {
//        ReconstructQueue reconstructQueue = new ReconstructQueue();
//        reconstructQueue.reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
        System.out.println(getDayEndSecond(new Date()));
    }
    //[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
    public int[][] reconstructQueue(int[][] people) {

        return people;
    }

    /**
     * 时间距离当天结束时间的秒
     *
     * @param nowDate
     * @return
     */
    public static int getDayEndSecond(Date nowDate) {
        // 获得两个时间的毫秒时间差异
        long diff = getEndTime(new Date()).getTime() - nowDate.getTime();
        //计算两个时间之间差了多少秒
        int second = (int)(diff / 1000);
        return second;
    }

    /*
     * 获取当前天的结束时间
     */
    public static Date getEndTime(Date date) {
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.HOUR_OF_DAY, 23);
        day.set(Calendar.MINUTE, 59);
        day.set(Calendar.SECOND, 59);
        day.set(Calendar.MILLISECOND, 999);
        return day.getTime();
    }

}
