package basicDataStructure;

/**
 * @Classname Sort
 * @Description TODO
 * @Date 2021/5/8 12:35
 * @Created by Fabric
 */
public class Sort {
 public static void numSort(int [] nums,int left,int right){
  if(left >= right) return;
   int point = left;
   for(int i =left;i<right;i++){
    if(nums[i]<nums[point]){
     nums[point] ^= nums[i];
     nums[i] ^= nums[point];
     nums[point] ^= nums[i];
     point = i;
    }
   }
   numSort(nums,left,point - 1);
   numSort(nums, point + 1, right);
 }
}