package leetcode_1738;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname 1738. 找出第 K 大的异或坐标值
 * @Description 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为m x n 由非负整数组成。
 *
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 *
 * 请你找出matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。

 * @Date 2021/5/19 10:09
 * @Created by Fabric
 */
public class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int column = matrix[0].length;
        int row = matrix.length;
        int ans = 0;
        int [] [] preFix = new int[matrix.length][matrix[0].length];
        for(int i =0;i<row;i++){
            preFix[i][0] = matrix[i][0];
            for (int j = 1; j < column; j++) {
                preFix[i][j] = matrix[i][j] ^ preFix[i][j-1];
            }
        }
        for (int i = 0; i < column; i++) {
            for (int j = 1; j < row; j++) {
                preFix[j][i] = preFix[j][i] ^ preFix[j-1][i];
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2){
                return o2 - o1;
            }
        });
        for(int i =0;i<row;i++){
            for (int j = 0; j < column; j++) {
                queue.add(preFix[i][j]);
            }
        }
        for(int i = 0; i < k; i++){
            ans = queue.poll();
        }
        return ans;

    }

    public static void main(String[] args) {
        int [][] matrix = {{8,10,5,8,5,7,6,0,1,4,10,6,4,3,6,8,7,9,4,2}};
        Solution sol = new Solution();
        System.out.println(sol.kthLargestValue(matrix,2));
    }
}