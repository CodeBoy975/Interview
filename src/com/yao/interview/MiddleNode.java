package com.yao.interview;

import java.util.List;

/**
 * 描述： 查找链表的中间节点
 *
 * @author pengjie_yao
 * @date 2019/8/2 14:38
 */
public class MiddleNode {

    /**
     *  节点
     */
    public static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *  查找中间节点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        // 1.判空
        if (head == null) {
            return null;
        }

        // 2.设置两个指针，一个快指针每次走两步，一个慢指针每次走一步，当快指针走完，则慢指针刚好走到中间位置
        ListNode fast = head;
        ListNode slower = head;

        // 3.快指针走完，则慢指针走到中间位置
        while (fast!= null && fast.next != null) {
            fast = fast.next.next;
            slower = slower.next;
        }
        return slower;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        MiddleNode middleNode = new MiddleNode();
        ListNode listNode6 = middleNode.middleNode(listNode);
        System.out.println(listNode6.val);
    }
}
