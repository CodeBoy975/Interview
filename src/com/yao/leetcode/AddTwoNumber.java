package com.yao.leetcode;

/**
 * 描述： 两数相加
 *
 * 题目：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 *      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *      输出：7 -> 0 -> 8
 *      原因：342 + 465 = 807
 * @author pengjie_yao
 * @date 2019/7/17 10:36
 */
public class AddTwoNumber {
    public static void main(String[] args) {

        Node node1 = new Node(2);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(4);
        node4.next = node5;
        node5.next = node6;
        Node node = addTwoNumber(node1, node4);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }

    }

    /**
     *   两个数相加(链表方式)
     * @param node1
     * @param node2
     * @return
     */
    public static Node addTwoNumber(Node node1, Node node2) {
        // 1. 新建一个链表，用来保存相加之后的结果
        Node result = new Node(0);
        Node end = result;
        // 2. 遍历两个链表进行相加，设置进位
        int carry = 0;
        while (node1 != null || node2 != null || carry != 0) {
            int node1Val = node1 == null ? 0 : node1.data;
            int node2Val = node2 == null ? 0 : node2.data;
            // 3. 将两个数值以及进位数相加
            int number = carry + node1Val + node2Val;
            // 重置为0
            carry = 0;
            if (number >= 10) {
                number = number % 10;
                carry = 1;
            }
            Node node = new Node(number);
            // 尾插法
            end.next = node;
            end = end.next;
            if (node1 != null) {
                node1  = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        // 将结果链表返回
        return result.next;
    }


    public static  class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
