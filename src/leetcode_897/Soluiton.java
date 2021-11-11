package leetcode_897;
import basicDataStructure.TreeNode;
//import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

/**
 * @Classname Soluiton
 * @Description TODO
 * @Date 2021/4/25 11:19
 * @Created by Fabric
 */
public class Soluiton {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode<int>();
        ArrayDeque<TreeNode> cache = new ArrayDeque<TreeNode>();
        Scanner sc = new Scanner(System.in);
        String [] strs = sc.nextLine().split(",");


    }
    public static void printBTree(TreeNode node){
        System.out.printf(" %d",node.getVal());
        if(node.getLeft()!=null) printBTree(node.getLeft());
        if(node.getRight()!=null) printBTree(node.getRight());
    }



}