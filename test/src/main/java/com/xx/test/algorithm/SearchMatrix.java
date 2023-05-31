package com.xx.test.algorithm;

public class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix.searchMatrix(matrix, 3));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int begin, mid, end;
        begin = mid = 0;
        int len1 = matrix.length, len2 = matrix[0].length;
        end = len1 * len2 - 1;
        while (begin < end) {
            mid = (begin + end) / 2;
            if (matrix[mid / len2][mid % len2] < target) {
                begin = mid + 1;
            }else{
                end = mid;
            }
        }
        return matrix[begin / len2][begin % len2] == target;
    }
}
