package leetcode_993;

import basicDataStructure.TreeNode;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/5/17 11:08
 * @Created by Fabric
 */
class Solution {
// public boolean isCousins(TreeNode root, int x, int y) {
//  int [] ans1 = findDepthFather(root,x,0);
//  int [] ans2 = findDepthFather(root,y,0);
//  if(ans1[1]>0 && ans2[1]>0 && ans1[0] == ans2[0] && ans1[1] != ans2[1]) return true;
//  else return false;
// }
// public int [] findDepthFather(TreeNode<Integer> root,int n,int depth){
//  int [] ans = new int[]{depth,-1};
//  if(root.left == null && root.right ==null) return new int[]{depth,-1};
//  if(root.left != null){
//   if(root.left.val == n){
//    ans[0] = depth;
//    ans[1] = root.val;
//   }else{
//    ans = findDepthFather(root.left,n,depth+1);
//    if(ans[1]>0) return ans;
//   }
//  }
//  if(root.right !=null){
//   if( root.right.val == n){
//    ans[0] = depth;
//    ans[1] = root.val;
//   }else{
//    ans = findDepthFather(root.right,n,depth+1);
//    if(ans[1]>0) return ans;
//   }
//  }
//  return ans;
// }
}