package com.xing.utils.tree;

/**
 * Main
 *
 * @author : xingshukui
 * @date : 2019-09-20 17:40
 * @desc :
 */
public class Main {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(3);
        TreeNode tree4 = new TreeNode(4);
        TreeNode tree5 = new TreeNode(5);
        TreeNode tree6 = new TreeNode(6);
        TreeNode tree7 = new TreeNode(7);
        TreeNode tree8 = new TreeNode(8);

        root.setLeft(tree1);
        root.setRight(tree2);

        tree1.setLeft(tree3);

        tree2.setLeft(tree4);
        tree2.setRight(tree5);

        tree3.setLeft(tree6);

        tree4.setLeft(tree7);
        tree4.setRight(tree8);

        preTraverseBTree(root);
//        inTraverseBTree(root);
    }


    /**
     * 先序遍历 根 -- 左 -- 右
     * @param root
     */
    private static void preTraverseBTree(TreeNode root) {

        if (root != null) {
            System.out.println(root.getVal());

            preTraverseBTree(root.getLeft());

            preTraverseBTree(root.getRight());
        }
    }


    /**
     * 中序遍历 左 -- 根 -- 右
     * @param root
     */
    private static void inTraverseBTree(TreeNode root) {
        if (root != null) {
            inTraverseBTree(root.getLeft());

            System.out.println(root.getVal());

            inTraverseBTree(root.getRight());
        }
    }
}
