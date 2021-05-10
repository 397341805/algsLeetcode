package TreePractice;
import basicDataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname FullBinaryTree
 * @Description TODO
 * @Date 2021/4/28 9:46
 * @Created by Fabric
 */
public class FullBinaryTree {
    private TreeNode<Integer> root ;
    //层次遍历读入二叉树
    public TreeNode<Integer> getTree(String[] value){
        TreeNode<Integer> p = new TreeNode<Integer>(Integer.parseInt(value[0]));
        TreeNode<Integer> q = p;
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        int i=0;
        while (p!=null){
            if(2*i+1<value.length){
                if(value[2*i+1].equals("null")){
                    p.setLeft(null);
                }else{
                    p.setLeft(new TreeNode<>(Integer.parseInt(value[2*i+1])));
                }
                queue.add(p.getLeft());
            }
            if (2*i+2<value.length){
                if(value[2*i+2].equals("null")){
                    p.setRight(null);
                }else{
                    p.setRight(new TreeNode<>(Integer.parseInt(value[2*i+2])));
                }
                queue.add(p.getRight());
            }
            p = queue.poll();
            i+=1;
        }
        return q;
    }

}