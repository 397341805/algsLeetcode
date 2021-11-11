package leetcode_421;

/**
 * @Classname Soluiton
 * @Description 数组中两个数的最大异或值
 * @Date 2021/5/16 16:55
 * @Created by Fabric
 */
class TreeNode {
    TreeNode left = null; //左零
    TreeNode right = null; // 右壹
    int val;
    public TreeNode() {

    }
}
public class Soluiton {
    public static TreeNode root = new TreeNode();
    public static final int MAX_BIT = 30;
    public  static int findMaximumXOR(int[] nums) {
        int result = 0;
        for(int i =0;i<nums.length; i++){
            add(nums[i]);
            result = Math.max(checkVal(nums[i]),result);
        }
        return result;

    }
    public static void main(String[] args) {
        int [] nums = {14,70,53,83,49,91,36,80,92,51,66,70};
        System.out.println(findMaximumXOR(nums));
    }
    public static void add(int val){
        TreeNode node = root;
        for(int i = MAX_BIT;i >= 0; i--){
            if(((val >> i) & 1) >0 ){//该位为1
                if (node.right!=null){
                    node = node.right;
                }else{
                    node.right = new TreeNode();
                    node = node.right;
                }
            }else{//该位为0;
                if (node.left!=null){
                    node = node.left;
                }else{
                    node.left = new TreeNode();
                    node = node.left;
                }
            }
        }
    }
    public static int checkVal(int val){
         int ans = 0;
         TreeNode node = root;
         for(int i = MAX_BIT;i >= 0; i--){
             int k = (val>>i) & 1;
             if(k == 0){
                if(node.right!=null){
                    ans = ans*2 + 1;
                    node = node.right;
                }else{
                    ans *= 2;
                    node = node.left;
                }
             }else{
                 if(node.left!=null){
                     ans = ans*2 + 1;
                     node = node.left;
                 }else{
                     ans *= 2;
                     node = node.right;
                 }
             }
         }
         return ans;
    }
}