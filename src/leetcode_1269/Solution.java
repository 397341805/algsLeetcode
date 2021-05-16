package leetcode_1269;

/**
 * @Classname Solution
 * @Description 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 *
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 *
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 *
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果

 * @Date 2021/5/13 10:17
 * @Created by Fabric
 */
class Solution {
   public static int numWays(int steps, int arrLen) {
      int mod = 1_000_000_007;
      int width = Math.min(arrLen -1,steps);
      int dp[][] = new int [steps+1][width+1];
      dp[0][0] = 1;

      for(int i =1;i<=steps;i++){
          for(int j = 0;j<=width;j++){
              int dp1 = ((i-1>=0 && j-1>=0) ? dp[i-1][j-1] : 0) % mod;
              int dp2 = ((i-1>=0) ? dp[i-1][j] : 0) % mod;
              int dp3 = ((i-1>=0) && j+1<=width ? dp[i-1][j+1] : 0) % mod;
              dp[i][j] = (((dp1+dp2) % mod) +dp3 ) % mod ;
          }
  }
      return dp[steps][0];
 }

 public static void main(String[] args) {
    int steps = 27;
    int arrLen = 7;
    System.out.println(numWays(steps,arrLen));
 }
}