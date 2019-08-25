package com.yao.leetcode;

import java.util.Stack;

/**
 * 描述： 判断是否是有效的二叉搜索树
 *
 * @author pengjie_yao
 * @date 2019/7/24 16:27
 */
public class ValidBST {


    public static void main(String[] args) {
/*
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(6);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;*/

   /*     TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(1);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;*/
////        treeNode1.left = treeNode3;


        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(6);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        System.out.println(isValidBST1(treeNode));
    }

    /**
     * 判断是否是二叉搜索树
     *   思路： 递归的方式： 设置下限值和上限值
     *         每次判断是如果左子树的的值大于节点值，则返回false
     *         如果右子树的值小于上限值，则返回flase
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return helpValidBST(root,null,null);
    }

    public static boolean helpValidBST(TreeNode root, Integer min, Integer max) {
        // 1. 进行判断
        if (root == null) {
            return true;
        }

        int val = root.val;
        // 2. 如果值小于最小值，不符合，主要是对右子树
        if(min!=null && val <= min){
            return false;
        }
        // 值大于最大值，则表示不对，主要是堆左子树
        if(max != null && val >= max) {
            return false;
        }
        // 3. 递归，对于左子树，则不能大于最大值
        if(!helpValidBST(root.left,min,val))return false;
        // 对于右子树，则不能小于最小值
        if(!helpValidBST(root.right,val,max)) return false;

        return true;
    }


    /**
     *  使用中序遍历方式实现
     * @param root
     * @return
     */
    public static boolean isValidBST1(TreeNode root) {

        Stack<TreeNode> stack = new Stack();

        int inorder = -1;

        while (!stack.isEmpty() || root != null) {
            // 1. 将左子树压入栈中
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 2. 出栈
            root = stack.pop();
            // 如果该值比上一个值小，则不符合条件
            if (root.val <= inorder) return false;
            // inorder是保存值，即遍历的的值，用来与下一个值进行比较
            inorder = root.val;
            // 找右子树
            root = root.right;
        }
        return true;
    }

    Stack<TreeNode> stack = new Stack();
    Stack<Integer> min = new Stack<>();
    Stack<Integer> max = new Stack<>();

    /**
     *  思路： 1 使用先序遍历方式
     * @param root
     * @return
     */
    public static boolean isValidBST2(TreeNode root) {

        return false;

    }


    public static class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
