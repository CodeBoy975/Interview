package com.yao.leetcode;

/**
 * 描述： 两两交换链表
 *
 * @author pengjie_yao
 * @date 2019/7/16 10:23
 */
public class swapNodeLink {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node node = swapNode(node1);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    /**
     * 递归实现交换节点
     */
    public static Node swapNode(Node head) {
        // 结束递归条件： 返回最后一个节点
        if (head == null || head.next == null) {
            return head;
        }
        // 保存第二个节点
        Node second = head.next;
        // 这里是second的next，是因为输入的是要交换的第一个节点
        // 返回的是交换好的子链表
        Node node = swapNode(second.next);
        // 两个节点进行交换即可
        head.next = node;
        second.next = head;
        return second;
    }
    /**
     * 节点
     */
    private static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

}
