package hot100_16;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/5/30 13:08
 * @Created by Fabric
 */
class Solution {
    Deque<Integer> window = new ArrayDeque<>();
    int idx =0;
    int sum =0;
    int result =Integer.MAX_VALUE;
    public int threeSumClosest(int[] nums, int target) {
        dfs(nums,-target,0);
        return result + target;
    }
    public void dfs(int[]nums,int sum ,int idx){
        if(window.size() == 3){
            result = Math.abs(sum) < Math.abs(result) ? sum:result;
            return;
        }
        if(idx>= nums.length){
            return;
        }
        for(;idx<nums.length; idx++){
//            if( Math.abs(sum + nums[idx]) < Math.abs(sum)){
                window.addLast(nums[idx]);
                dfs(nums,sum+nums[idx],idx+1);
                window.removeLast();
//            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] nums = {-1,2,1,-4};
        int k = 1;
        char c;
        System.out.println(sol.threeSumClosest(nums,k));


    }
}