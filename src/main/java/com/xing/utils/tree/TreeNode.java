package com.xing.utils.tree;

/**
 * TreeNode
 *
 * @author : xingshukui
 * @date : 2019-09-20 17:40
 * @desc :
 */
public class TreeNode {
    private Integer val;
    private TreeNode left;
    private TreeNode right;


    public TreeNode(Integer val) {
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

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }
}
