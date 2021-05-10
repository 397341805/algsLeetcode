package leetcode_740;
import java.util.*;

/**
 * @Classname Solution of 740. Delete and Earn
 * @Description Given an array nums of integers, you can perform operations on the array.
 *
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 *
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.

 * @Date 2021/5/5 9:43
 * @Created by Fabric
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        HashMap<Integer,Integer> numMap = new HashMap<>();
        //HashMap 排序： 先转换成List 再排序
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], numMap.getOrDefault(nums[i], 0)+nums[i]);
        }
        List<HashMap.Entry<Integer, Integer>> mapList = new ArrayList<HashMap.Entry<Integer, Integer>>(numMap.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getKey() - o1.getKey());
//                return (o1.getKey()) - (o2.getKey());
            }});
        int [] dp = new int [3];
        int pre = mapList.get(0).getKey();
        dp[0] = mapList.get(0).getValue();
        if(mapList.size()>1){
            if(Math.abs(mapList.get(1).getKey() - pre) == 1){
                dp[1] = Math.max(mapList.get(1).getValue(),dp[0]);
            }else{
                dp[1] = dp[0] + mapList.get(1).getValue();
            }
        }
        pre = mapList.get(1).getKey();
        for(int i = 2;i < mapList.size();i++){
            if(Math.abs(mapList.get(i).getKey() - pre) == 1){
                dp[2] = Math.max(dp[1],dp[0]+mapList.get(i).getValue());
            }else{
                dp[2] = dp[1] + mapList.get(i).getValue();
            }
            dp[0] = dp[1];
            dp[1] = dp[2];
            pre = mapList.get(i).getKey();
        }
        if(nums.length==2) return dp[1];
        else return dp[2];
    }
    public static void main(String[] args) {
        int [] nums = {1,1,1,2,4,5,5,5,6};
        Solution sol = new Solution();
        System.out.println(sol.deleteAndEarn(nums));
    }
}