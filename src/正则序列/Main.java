package 正则序列;
import java.util.Scanner;
import java.util.Arrays;
/**
 * @Classname Main
 * @Description TODO
 * @Date 2021/5/8 19:12
 * @Created by Fabric
 */
public class Main {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int [] nums = new int[num];
    for(int i = 0; i < num; i++){
    nums[i] = sc.nextInt();
  }
    int ans = 0;
     Arrays.sort(nums) ;
  for(int i = 0;i<num;i++){

      ans += Math.abs(nums[i] - i - 1);
  }
    System.out.println(ans);
 }
}