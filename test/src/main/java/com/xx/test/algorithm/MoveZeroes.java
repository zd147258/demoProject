package com.xx.test.algorithm;

public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] ints = {1,0,3,12};
        moveZeroes.moveZeroes(ints);
        for (int n : ints){
            System.out.print(n + ",");
        }
    }
    //0,1,0,3,12,0,16,0,0,17
    //1,0,0,3,12,0,16,0,0,17
    //1,3,0,0,12,0,16,0,0,17
    //1,3,12,16,17,0,0,0,0,0
    public void moveZeroes(int[] nums) {
//        //1
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0){
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[j] != 0){
//                        int temp = nums[j];
//                        nums[j] = nums[i];
//                        nums[i] = temp;
//                        break;
//                    }
//                }
//            }
//        }

        //2
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                if (count != i){
                    nums[count] = nums[i];
                    nums[i] = 0;
                    count++;
                }else {
                    count++;
                }
            }
        }
    }
}
