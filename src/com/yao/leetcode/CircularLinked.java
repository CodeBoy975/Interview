package com.yao.leetcode;

import javax.xml.soap.Node;

/**
 * 描述:  1 判断链表是否有环
 *        2 判断环的长度
 *        3 判断入环点的位置
 *
 * @author pengjie_yao
 * @date 2019/7/13 9:46
 */
public class CircularLinked {


    /**
     * 判断链表是否有环： 采用快慢指针方式
     *
     * @param head
     */
    public static Boolean isCycle(ListNode head) {
        // 1 设置快慢指针
        ListNode slower = head;
        ListNode quick = head;
        // 2 遍历链表判断
        while (quick != null && quick.next != null) {
            // 3 快指针每次走两步，慢指针每次走一步，两者如果相遇则跳出循环
            slower = slower.next;
            quick = quick.next.next;
            if (slower == quick) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断环的长度： 自己解法
     *
     * @param node
     * @return
     */
    public static Integer cycleLength(ListNode node) {
        // 相遇次数
        final Integer FIRST_MEET = 1;
        final Integer SECOND_MEET = 2;
        // 1 设置快慢指针
        ListNode slower = node;
        ListNode quick = node;
        // 相遇次数
        Integer meetCount = 0;
        // 环的长度
        Integer length = 0;
        // 2 当两者相遇时，设置计数器，当两者再次相遇，再计数器的长度则为环的长度
        while (quick != null && quick.next != null) {
            slower = slower.next;
            quick = quick.next.next;
            if (slower == quick) {
                // 相遇的次数
                meetCount++;
            }
            if (meetCount.equals(FIRST_MEET)) {
                // 第一次相遇，则继续执行，开始计算环的长度
                length++;
            }
            if (meetCount.equals(SECOND_MEET)) {
                // 第二次相遇，则跳出循环
                break;
            }
        }
        return length;
    }

    /**
     * 判断环的长度： 网上版本
     *
     * @param node
     * @return
     */
    public static Integer cycleLength1(ListNode node) {
        // 1 设置快慢指针
        // 2 当两者相遇时，设置计数器，当两者再次相遇，再计数器的长度则为环的长度
        ListNode slower = node;
        ListNode quick = node;
        while (quick != null && quick.next != null) {
            slower = slower.next;
            quick = quick.next.next;
            if (slower == quick) {
                // 计算环的长度
                // 环的长度
                Integer length = 0;
                while (quick != null && quick.next != null) {
                    slower = slower.next;
                    quick = quick.next.next;
                    length++;
                    if (slower == quick) {
                        return length;
                    }
                }
            }
        }
        return 0;
    }

    /**
     *  入环点
     * @param head
     * @return
     */
    public static ListNode inCycleNode(ListNode head) {
        // 快慢指针
        ListNode slower = head;
        ListNode quick = head;
        // 开始节点
        ListNode startNode = head;
        while (quick != null && quick.next != null) {
            slower = slower.next;
            quick = quick.next.next;
            if (slower == quick) {
                // 1 从相遇点开始，设置一个指针以步长为1继续前进
                while (startNode != slower) {
                    // 2 设置一个指针从起点开始，步长也为1
                    startNode = startNode.next;
                    slower = slower.next;
                    if (startNode == slower) {
                        return startNode;
                    }
                }

            }
        }
        return null;
    }

    public static void main(String[] args) {
       /* Node node = new Node(5);
        Node node1 = new Node(3);
        Node node2 = new Node(7);
        Node node3 = new Node(2);
        Node node4 = new Node(6);
        Node node5 = new Node(8);
        Node node6 = new Node(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;*/
        // 判断链表是否有环
//        Boolean result = isCycle(node);
//        System.out.println("该链表是否是循环链表的结果为：" + result);
        // 环的长度
//        Integer length = cycleLength1(node);
//        System.out.println("该链表环的长度为：" + length);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1;
        Boolean cycle = isCycle(node1);
        System.out.println(cycle);
        /*Node result = inCycleNode(node1);
        System.out.println("入环点为："+result.data);*/
    }

    /**
     * 节点
     */
    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int data) {
            this.val = val;
        }
    }
}
