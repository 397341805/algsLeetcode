package leetcode_1707;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/5/24 10:45
 * @Created by Fabric
 */
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int [][] sortQueries = new int [queries.length][3];
        int [] result = new int [queries.length];
        for (int i = 0; i < queries.length; i++) {
            sortQueries[i][0] = queries[i][0];
            sortQueries[i][1] = queries[i][1];
            sortQueries[i][2] = i;
        }
        Arrays.sort(sortQueries,Comparator.comparingInt(q -> q[1]));
        Trie root = new Trie();
        int idx = 0;
        for(int[] ques:sortQueries ){
            int x = ques[0];
            int m = ques[1];
            int seq = ques[2];
            while (idx< nums.length && nums[idx]<m){
                root.insert(nums[idx]);
                idx++;
            }
            if(idx ==0){
                result[seq] = -1;
            }else{
                result[seq] = root.getMaxXor(x);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
       int [] nums = {0,1,2,3,4};
       int [][] queries = {{3,1},{1,3},{5,6}};
       System.out.println(Arrays.toString(sol.maximizeXor(nums,queries)));
    }
}

class Trie {
    static final int L = 30;
    Trie[] children = new Trie[2];
    public void insert(int num){
        Trie node = this;
        for (int i = L-1 ; i>=0;--i) {
            int bit = (num >> i) & 1;
            if(node.children[bit] == null){
                node.children[bit] = new Trie();
            }
            node =  node.children[bit];
        }
    }
    public int getMaxXor(int num){
        Trie node = this;
        int ans = 0;
        for (int i = L-1; i >= 0; --i) {
            int bit = (num >> i) & 1;
            if(node.children[bit^1] != null){
                ans |= 1<<i; //将答案该位置1
                bit ^=1;
            }
            node = node.children[bit];
        }
        return ans;
    }
}