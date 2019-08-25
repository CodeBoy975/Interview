package com.yao.leetcode;

/**
 * 描述： 二叉树的最近祖先
 *
 * @author pengjie_yao
 * @date 2019/7/25 20:28
 */
public class findNearAncestor {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(0);
        TreeNode treeNode6 = new TreeNode(8);

        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(4);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
//        TreeNode treeNode9 = lowestCommonAncestor(treeNode, treeNode3, treeNode8);
        TreeNode treeNode9 =lowestCommonAncestor1(treeNode, treeNode3, treeNode8);
        System.out.println(treeNode9.val);


    }

    /**
     * 二叉树：  递归方式
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 1. root节点为空判断
        if (root == null) {
            return null;
        }
        // 2. 如果左子树或者右子树相等，则直接返回
        if (root == p || root == q) {
            return root;
        }
        // 3. 左子树递归，返回节点是找到的节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 4. 右子树递归，返回节点是找到的节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 5. 如果左子树返回节点不为空，返回左子树
        if(left  == null) {
            return right;
        }
        // 6. 如果右子树返回节点不为空，则返回右子树
        if (right == null) {
            return left;
        }
        // 7. 如果都为空，则直接放回根节点
        return root;
    }


    /**
     *  二叉搜索树：递归方式
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        // 1. root节点为空判断
        if (root == null) {
            return null;
        }
        // 2. 如果左子树或者右子树相等，则直接返回
        if (root == p || root == q) {
            return root;
        }

        if (p.val < root.val && q.val < root.val) {
            // 3. 左子树递归，返回节点是找到的节点
            return  lowestCommonAncestor2(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            // 4. 右子树递归，返回节点是找到的节点
            return lowestCommonAncestor2(root.right, p, q);
        }else {
            return root;
        }
    }


    /**
     *  二叉搜索树的方式： 非递归
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }else {
                return root;
            }
        }
        return null;
    }
        public static  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
