package com.yao.leetcode;

/**
 * 描述： 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * @author pengjie_yao
 * @date 2019/7/17 8:42
 */
public class ReverseLinkedByK {
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
//        Node node  = reverseByNumber(node1, 3);
        Node node = reverseKGroup(node1, 3);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }

    }

    public static Node reverseByNumber(Node head, int k) {

        // 每k个节点反转链表
        // 1 设置三个变量 pre、start、end
        Node result = new Node(0);
        result.next = head;
        Node end = head;
        Node pre = head;
        // 2 结束条件 链表为空的时候
        // 循环k轮，找到翻转的尾指针，将翻转区域进行翻转
        while (end.next != null) {
            for (int i = 0; i < k - 1; i++) {
                // 把end移动到要翻转的位置
                if (end.next != null) {
                    end = end.next;
                }
            }
            if (end == null) {
                break;
            }
            // 进行翻转
            Node start = pre;
            // 待翻转的节点
            Node next = end.next;

            // 将翻转的尾指针设为NULL
            end.next = null;
            Node node = reverseNode(start);
            pre.next = node;
            start.next = next;
            end = pre;

        }

        return result.next;
    }


    public static Node reverseKGroup(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node pre = dummy;
        Node end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++){
                end = end.next;
            }
            if (end == null) {
                break;
            }
            Node start = pre.next;
            Node next = end.next;
            end.next = null;
            pre.next = reverseNode(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }


    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static Node reverseNode(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            // 保存下一个节点
            Node next = cur.next;
            // 将当前节点指向前节点
            cur.next = pre;
            // 让前节点变成当前节点
            pre = cur;
            // 下一个节点变为当前节点
            cur = next;
        }
        return pre;
    }

    /**
     * 节点
     */
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
