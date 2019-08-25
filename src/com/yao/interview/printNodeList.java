package com.yao.interview;

import java.util.Stack;

/**
 * 描述： 从尾到头打印链表
 *
 * @author pengjie_yao
 * @date 2019/8/3 16:17
 */
public class printNodeList {


    public static void main(String[] args) {

        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        node.next = node1;
        node1.next = node2;
        System.out.println("原链表为:");
        print(node);
        System.out.println("从尾到头打印的链表为：");
        printNodeList(node);
    }

    /**
     * 遍历链表
     */
    public static void print(Node head) {
        if (head == null)
            return;
        Node printNode = head;
        while (printNode != null) {
            System.out.print(printNode.val + " ");
            printNode = printNode.next;
        }
        System.out.println();
    }

    /**
     *  反转后输出链表
     * @param head
     */
    public static void printNodeList(Node head) {
        // 1.判空
        if (head == null) {
            return;
        }

        // 2.定义一个堆栈，用来输出
        Stack stack = new Stack();
        Node node = head;
        // 3.遍历链表，压入栈中
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        // 4.输出栈中元素
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }


    /**
     * 节点
     */
    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
