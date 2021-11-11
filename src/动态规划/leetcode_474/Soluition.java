package 动态规划.leetcode_474;

/**
 * @Classname Soluition
 * @Description TODO
 * @Date 2021/6/6 11:44
 * @Created by Fabric
 */
class Solution {

	public int findMaxForm(String[] strs, int m, int n) {
		int len = strs.length;
		int [][] nums = new int [strs.length][2];
		//预处理数组
		for(int i = 0;i<len;i++){
			int tmpLen = strs[i].length();
			int zeroCount = tmpLen - strs[i].replace("0","").length();
			int oneCount = tmpLen - zeroCount;
			nums[i][0] = zeroCount;
			nums[i][1] = oneCount;
		}
		//动态规划
		int dp[][][] = new int[len+1][m+1][n+1];
		dp[0][0][0] = 0;
		for (int i = 0; i <= len; i++) {
		    int zero = nums[i][0];
		    int one = nums[i][1];
		    for(int j =0;j<=m;j++){
		    	for (int k = 0; k <= n; k++) {
		    	    dp[i][j][k] = dp[i-1][j][k];
		    	    if(j>= zero && k >= one){
		    	    	dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-zero][k-one]+1);
					}
		    	}
			}
		}
		return dp[len][m][n];
	}

	public static void main(String[] args) {
		String [] strs ={ "10","0001","111001","1","0"};
		int m = 5;
		int n = 3;
		Solution sol = new Solution();
		System.out.println(sol.findMaxForm(strs,m,n));
	}
}