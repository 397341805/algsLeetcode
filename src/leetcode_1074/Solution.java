package leetcode_1074;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/5/29 11:02
 * @Created by Fabric
 */
public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int [][] preMatrix = new int [row+1][column+1];
        preMatrix[1][1] = matrix[0][0];
        for(int i =1;i<=row;i++){
            for(int j = 1;j<=column;j++){
                preMatrix[i][j] = preMatrix[i-1][j] + preMatrix[i][j-1] - preMatrix[i-1][j-1] + matrix[i-1][j-1];
            }
        }

        int result = 0;
        for(int rr =1;rr<=row;rr++){
            for(int ld = 1;ld<=column;ld++){
                for(int rl = 1;rl<=rr;rl++){
                    for(int lt = 1;lt<=ld;lt++){
                        if(preMatrix[rr][ld] + preMatrix[rl-1][lt-1] - preMatrix[rr][lt-1] - preMatrix[rl-1][ld] == target) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int matrix [][] = {{0,1,0},{1,1,1},{0,1,0}};
        int num = 0;
        System.out.println(sol.numSubmatrixSumTarget(matrix,num));
    }
}