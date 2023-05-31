package com.xx.test.algorithm;

public class CanCompleteCircuit {
    public static void main(String[] args) {
        CanCompleteCircuit canCompleteCircuit = new CanCompleteCircuit();
        int[] gas = new int[]{2};
        int[] cost = new int[]{2};
        System.out.println(canCompleteCircuit.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int rest = 0, run = 0, start = 0;
        for (int i = 0; i < gas.length; ++i){
            run += (gas[i] - cost[i]);
            rest += (gas[i] - cost[i]);
            if (run < 0){
                start = i + 1;
                run = 0;
            }
        }
        return rest < 0 ? -1 : start;
    }
}
