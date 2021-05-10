package basicDataStructure;

/**
 * @Classname TreeNode
 * @Description Definition for a binary tree node.
 * @Date 2021/4/25 11:22
 * @Created by Fabric
 */


public class TreeNode<T> {
    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    T val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {}
    public TreeNode(T val) { this.val = val; }
    public TreeNode(T val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
