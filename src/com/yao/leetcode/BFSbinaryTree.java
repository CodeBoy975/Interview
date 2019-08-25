package com.yao.leetcode;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 描述： 二叉树的广度优先搜索
 * 思路： 通过队列实现
 *
 * @author pengjie_yao
 * @date 2019/8/13 13:54
 */
public class BFSbinaryTree {

    /**
     * 节点定义
     */
    public static class Tree {

        Tree left;
        Tree right;
        int val;

        public Tree(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字的个数：");
        int T = sc.nextInt();
        int[] t = new int[T];
        System.out.println("请输入数字，以空格分隔：");
        for (int i = 0; i < T; i++) {
            t[i] = sc.nextInt();
        }

        Tree root = null;
        for (int i = 0; i < T; i++) {
            root = insert(root, t[i]);
        }

        System.out.println("先序优先遍历的递归方式：");
        preTraversing(root);
        System.out.println();
        System.out.println("先序优先遍历的非递归方式：");
        preTraversing1(root);
        System.out.println();
        System.out.println("中序优先遍历的递归方式：");
        midTraversing(root);
        System.out.println();
        System.out.println("中序优先遍历的非递归方式：");
        midTraversing1(root);
        System.out.println();

        System.out.println("后序优先遍历的递归方式：");
        postTraversing(root);
        System.out.println();
        System.out.println("后序优先遍历的非递归的双栈法1方式：");
        postTraversing1(root);
        System.out.println();
        System.out.println("后序优先遍历的非递归的双栈法2方式：");
        postTraversing2(root);

        System.out.println();
        System.out.println("广度优先遍历：");
        bfsTraversing(root);
    }


    /**
     * 广度优先遍历(BFS)
     */
    public static void bfsTraversing(Tree root) {

        // 1.判空
        if (root == null) {
            return;
        }
        // 2.定义队列
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);
        // 3.遍历队列
        while (!queue.isEmpty()) {
            // 4.获取队列的队头
            Tree node = queue.peek();
            // 5.移除队头
            queue.remove();
            // 6. 输出队头
            System.out.print(node.val + " ");
            // 7.如果左节点不为空，则加入到队列中
            if (node.left != null) {
                queue.add(node.left);
            }
            // 8.如果右节点不为空，则加入到节点中去
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


    /**
     * 二叉排序树
     *
     * @param root
     * @param data
     * @return
     */
    public static Tree insert(Tree root, int data) {

        // 1.判空
        if (root == null) {
            return new Tree(data);
        }
        // 2.判断该值是否比父节点小，是则递归左边
        Tree currentTree;
        if (data < root.val) {
            currentTree = insert(root.left, data);
            root.left = currentTree;
        } else {
            // 3.该值比父节点大，递归右边
            currentTree = insert(root.right, data);
            root.right = currentTree;
        }
        return root;
    }

    /**
     * 递归的先序遍历
     */
    public static void preTraversing(Tree root) {
        // 1.判空
        if (root == null) {
            return;
        }
        // 输出根节点
        System.out.print(root.val + " ");
        // 2.递归左节点
        preTraversing(root.left);
        // 3. 递归右节点
        preTraversing(root.right);
    }

    /**
     * 非递归的先序遍历
     *
     * @param root
     */
    public static void preTraversing1(Tree root) {
        // 1.判空
        if (root == null) {
            return;
        }
        // 2.定义栈，并把树压入栈中
        LinkedList<Tree> stack = new LinkedList<>();
        stack.push(root);
        // 3.判断栈是否为空
        while (!stack.isEmpty()) {
            // 4.弹出栈中元素
            Tree currentTree = stack.pop();
            // 5.先输出根节点的值
            System.out.print(currentTree.val + " ");
            // 6.先将右节点压入栈中，因为栈的特性，先入后出，所以压入右，在压入左，则先弹出的是左
            if (currentTree.right != null) {
                stack.push(currentTree.right);
            }
            // 7.压入左节点
            if (currentTree.left != null) {
                stack.push(currentTree.left);
            }
        }
    }


    /**
     * 递归的中序遍历: 左节点-跟节点-右节点
     */
    public static void midTraversing(Tree root) {
        // 1.判空
        if (root == null) {
            return;
        }
        // 2.递归左节点
        preTraversing(root.left);
        // 输出根节点
        System.out.print(root.val + " ");
        // 3. 递归右节点
        preTraversing(root.right);
    }


    /**
     *  非递归方式的中序遍历
     * @param root
     */
    public static void midTraversing1(Tree root) {
        // 1.判空
        if (root == null) {
            return;
        }
        // 2.定义栈
        LinkedList<Tree> stack = new LinkedList<>();
        Tree currentNode = root;
        while (currentNode!=null ||  !stack.isEmpty()) {
            // 3.遍历出左子树中额所有左节点，压入栈中
            while (currentNode!=null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            // 3.弹出栈，并输出
            currentNode = stack.pop();
            System.out.print(currentNode.val+" ");
            currentNode = currentNode.right;
        }
    }


    /**
     * 递归的后序遍历: 左节点-右节点-跟节点
     */
    public static void postTraversing(Tree root) {
        // 1.判空
        if (root == null) {
            return;
        }

        // 2.递归左节点
        preTraversing(root.left);
        // 3. 递归右节点
        preTraversing(root.right);
        // 4.输出根节点
        System.out.print(root.val + " ");
    }

    /**
     * 非递归的后序遍历: 左节点-右节点-跟节点
     * 双栈法的思路：
     *   1. 一个栈用来表示当前处理的节点，另外一个栈用来输出
     *   2. 在处理两个栈的时候，将根节点同时压入两个栈中，然后压入右子树的根节点，再压入右子树
     *   3. 直到压入的右子树没有元素压栈，弹出栈1的元素，把它的左子树压入栈1和栈2里面，直到它的右子树压完。
     */
    public static void postTraversing1(Tree root) {
        // 1.判空
        if (root == null) {
            return;
        }

        // 2.栈1用来保存临时处理，栈2输出
        LinkedList<Tree> stack1 = new LinkedList<Tree> ();
        LinkedList<Tree> stack2 = new LinkedList<Tree> ();
        Tree currentNode = root;
        // 3.当前节点不为空或者栈1不为空
        while (currentNode!=null || !stack1.isEmpty()) {

            // 减右子树都压入栈1和栈2中
            while (currentNode != null) {
                stack1.push(currentNode);
                stack2.push(currentNode);
                currentNode = currentNode.right;
            }
            // 弹出栈1的元素，即右节点，然后赋值去找它的左节点
            currentNode = stack1.pop();
            currentNode = currentNode.left;
        }
        //  将存在栈2的元素进行遍历
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val+" ");
        }
    }

    /**
     *
     * 后序遍历双栈法：
     *          第二种思路也是使用两个栈，它也是使用一个栈来保存当前的指向，用一个栈来保存结果集，
     *          只不过这个结果集是和后序遍历是反着的，比如后序遍历最后保存根节点，它就先存储根节点，
     *          后序遍历倒数第二个元素是根节点的右子树的元素，它就第二个保存根节点的右子树的元素。
     *          如果把树做一个镜像，也就是所有的节点的左右子树都进行一次交换的话
     * @param root
     */
    public static void postTraversing2(Tree root) {
        // 1.判空
        if (root == null) {
            return;
        }

        // 2.栈1用来保存临时处理，栈2输出
        LinkedList<Tree> stack1 = new LinkedList<Tree> ();
        LinkedList<Tree> stack2 = new LinkedList<Tree> ();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            root = stack1.pop();
            if (root == null) {
                continue;
            }
            stack2.push(root);
            stack1.push(root.left);
            stack1.push(root.right);

        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val+" ");
        }
    }

}
