package leetcode_1482;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2021/5/9 14:38
 * @Created by Fabric
 */
class Solution {
 int result;
 public static int minDays(int[] bloomDay, int m, int k) {
     Deque<Integer> stack = new ArrayDeque<>();
     stack.addLast(bloomDay[0]);
     for(int i =1;i<bloomDay.length; i++){
         if(bloomDay[i]<stack.getFirst()){
             stack.addFirst(bloomDay[i]);
         }
         if (stack.getLast()<bloomDay[i]){
             stack.addLast(bloomDay[i]);
         }
     }
    if(bloomDay.length < m*k) return -1;
    else return binarysearch(bloomDay,stack.getFirst(),stack.getLast(),m,k);
 }
 public static int binarysearch(int [] bloomDay,int low,int high,int m,int k){
     if(low == high) return high;
     int mid =  low + (high - low)/2;
      int tmpM = 0;
      int tmpK = 0;
      for(int i =0;i<bloomDay.length; i++){
          if(bloomDay[i]<= mid){
              tmpM++;
          }else{
              tmpM = 0;
          }
          if(tmpM == k){
              tmpK++;
              tmpM = 0;
          }
      }
      if(tmpK>=m){
          return binarysearch(bloomDay,low,mid,m,k);
      }else {
          return binarysearch(bloomDay,mid+1,high,m,k);
      }

 }

    public static void main(String[] args) {
        int [] nums = {1,10,3,10,2};
        System.out.println(minDays(nums,3,1));
    }
}