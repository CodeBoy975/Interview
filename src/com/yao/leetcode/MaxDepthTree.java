package com.yao.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 描述： 二叉树的最大深度
 *
 * @author pengjie_yao
 * @date 2019/8/19 20:36
 */
public class MaxDepthTree {

    /**
     * 节点定义
     */
    public static class TreeNode {

        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * BFS:求树的最大深度
     *
     * @param root
     * @return
     *//*
    public static int maxDepth(TreeNode root) {

        // 1.如果为null，直接返回
        if (root == null) {
            return 0;
        }
        // 2.采用层次遍历的方式，每次遍历都扫描
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        // 3.遍历队列
        while (!queue.isEmpty()) {

            // 4.用来存储每一层的节点
            Queue<TreeNode> queue1 = new LinkedList<>();
            // 5.遍历每一层的接待你
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node.left != null || node.right != null) {
                    if (node.left != null) {
                        queue1.add(node.left);
                    }
                    if (node.right != null) {
                        queue1.add(node.right);
                    }
                }
            }
            // 6.将下一层的节点赋值给新的队列
            if (!queue1.isEmpty()) {
                queue = queue1;
            }
            // 7.深度+1
            depth++;

        }
        return depth;
    }*/


    /**
     * DFS求树的深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        // 1.判空
        if (root == null) {
            return 0;
        }
        // 2.定义栈
        Stack<TreeNode> stack = new Stack<TreeNode>();

        int maxDepth = 1;
        stack.add(root);
        int temp = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 左子树压入栈中
            if (node.left != null || node.right != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                temp++;
                maxDepth = Math.max(temp, maxDepth);
            }
        }
        return maxDepth;
    }

    /**
     * 递归方式实现
     *
     * @param root
     * @return
     *//*
    public static int maxDepth(TreeNode root) {
        // 1.判空，即递归出口
        if (root == null) {
            return 0;
        }
        // 2.左子树的最大深度
        int leftMin = maxDepth(root.left);
        // 3.右子树的最大深度
        int rightMin = maxDepth(root.right);
        // 4.取两者中的最大值+1作为最大深度结果返回
        return 1 + Math.max(leftMin, rightMin);
    }*/
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        int i = maxDepth(treeNode1);
        System.out.println(i);

    }
}
