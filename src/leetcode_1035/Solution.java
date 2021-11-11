package leetcode_1035;

/**
 * @Classname 1035. 不相交的线
 * @Description 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 *
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 *
 *  nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 *
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uncrossed-lines
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/5/21 9:36
 * @Created by Fabric
 */
class Solution {
    //超时
//    public int maxUncrossedLines(int[] nums1, int[] nums2) {
//        if(nums2.length  > nums1.length){
//            return dfs(nums1,nums2,0,0,0);
//        }else{
//            return dfs(nums2,nums1,0,0,0);
//        }
//    }
//    public int dfs(int [] nums1,int [] nums2 ,int l1,int l2,int ans){
//        if(l1 >= nums1.length || l2 >= nums2.length ) return ans;
//        //默认nums2长
//        for (int i = l2; i < nums2.length; i++) {
//            if(nums1[l1] == nums2[i]){
//                return Math.max(dfs(nums1,nums2,l1+1,i+1,ans+1),dfs(nums1, nums2, l1 + 1,l2, ans ));
//            }
//        }
//        return dfs(nums1, nums2, l1 + 1,l2, ans );
//    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int [][] dp = new int[nums1.length+1][nums2.length+1];
        dp[0][0] = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }

        }
        return dp[nums1.length][nums2.length];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] nums1 = {15,14,1,7,15,1,12,18,9,15,1,20,18,15,16,18,11,8,11,18,11,11,17,20,16,20,15,15,9,18,16,4,16,1,13,10,10,20,4,18,17,3,8,1,8,19,14,10,10,12};
        int [] nums2 = {12,8,17,4,2,18,16,10,11,12,7,1,8,16,4,14,12,18,18,19,19,1,11,18,1,6,12,17,6,19,10,5,11,16,6,17,12,1,9,3,19,2,18,18,2,4,11,11,14,9,20,19,2,20,9,15,8,7,8,6,19,12,4,11,18,18,1,6,9,17,13,19,5,4,14,9,11,15,2,5,4,1,10,11,6,4,9,7,11,7,3,8,11,12,4,19,12,17,14,18};
        System.out.println(sol.maxUncrossedLines(nums1,nums2));
    }
}