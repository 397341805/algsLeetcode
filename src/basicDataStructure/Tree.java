package basicDataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import basicDataStructure.TreeNode;
//import jdk.internal.org.objectweb.asm.tree.analysis.Value;
/**
 * @Classname treeBasicOperation
 * @Description TODO
 * @Date 2021/4/27 10:57
 * @Created by Fabric
 */

/**
 这道题 因为input输入  所以把整套流程实现一下
 */
public class Tree<T> {
 private TreeNode<T> root ;
 public Tree(){
  this.root = null;
 }

// public TreeNode<T> preCreateTree(TreeNode<T> t){
//  Scanner sc = new Scanner(System.in);
//  T tmp = sc.next();
//  TreeNode<T> root = new TreeNode<T>();
//  root.setVal(Value[0]);
//  for (T e:Value){
//
//  }
// }
 /**
  使用getTree方法将层次遍历序列构建一个二叉树
  */
 public Tree(T[] value){
  this.root = getTree(value);
 }
 private TreeNode<T> getTree(T[] value){
  TreeNode<T> p = new TreeNode<>(value[0]);
  TreeNode<T> q = p;
  Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
  int i=0;
  while (p!=null){
   if(2*i+1<value.length){
    p.left = new TreeNode<>(value[2*i+1]);
    queue.add(p.left);
   }
   if (2*i+2<value.length){
    p.right = new TreeNode<>(value[2*i+2]);
    queue.add(p.right);
   }
   p = queue.poll();
   i+=1;
  }
  return q;
 }

 /**
  * 层次遍历
  */
 public void getSort(TreeNode<T> p){
  Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
  while (p!=null){
   System.out.print(p.getVal().toString()+" ");
   if(p.left!=null){
    queue.add(p.left);
   }
   if(p.right!=null){
    queue.add(p.right);
   }
   p = queue.poll();
  }

 }
 /**
  关键目标函数  也是使用层次遍历的思想  遍历的第1/3/7/15....2N-1项即为目标

  */
 public ArrayList getSolution(TreeNode<T> p){
  Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
  ArrayList list = new ArrayList();
  int i=1;
  while (p!=null){
      if(isG(i)){
           list.add(p.getVal());
      }
      i++;
      if(p.left!=null){
          queue.add(p.left);
   }
   if(p.right!=null){
    queue.add(p.right);
   }
   p = queue.poll();
  }
  return list;
 }
 /*判断  如果是层次遍历的话  遍历的第1/3/7/15....2N-1项即为目标，这里判断i是否符合*/
 private static int n =2;
 public static boolean isG(int i){
  if(i==n-1&&i!=0){
   n=n*2;
   return true;
  }else
   return false;
 }
 public static void main(String[] args) throws IOException {
  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  String str = bf.readLine();
  bf.close();
  String[] value = str.substring(1,str.length()-1).split("\\,");
  // System.out.println(Arrays.toString(value));
  Tree<String> tree = new Tree<String>(value);
  //tree.getSort(tree.root);
  //System.out.println();
  System.out.println(tree.getSolution(tree.root).toString());
  // for(int i=0;i<10;i++){
  //    if(isG(i)){
  //       System.out.println(i);
  //  }
  //}
 }
}

