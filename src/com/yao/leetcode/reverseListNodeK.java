package com.yao.leetcode;

/**
 * 描述： 每k个节点一组进行反转链表
 *
 * @author pengjie_yao
 * @date 2019/8/6 21:35
 */
public class reverseListNodeK {
    /**
     *  定义的节点
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     *   每k个节点进行翻转链表
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        // 1.判空
        if (head == null || k == 0) {
            return null;
        }
        // 2.定义一个头结点的前节点
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        // 3. 定义一个前节点和尾节点，用来保存翻转的前前节点以及尾节点
        ListNode pre = preHead;
        ListNode end = preHead;

        // 4. 遍历链表
        while (end.next != null) {

            //  5.获取k个节点后的尾节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 6.如果已经为空，则直接跳出循环
            if (end == null) {
                break;
            }
           // 7.保存前节点，以及尾节点的下一个节点
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            // 8.进行反转，返回翻转后的节点
            ListNode reverseList = reverseNodeList(start);
            // 9.拼接头部
            pre.next = reverseList;
            // 10.拼接尾部,此时反转后的start节点，其实是尾节点
            start.next = next;
            // 11.重置
            pre = start;
            end = pre;
        }
        // 12.返回结果
        return preHead.next;
    }

    /**
     *  反转链表
     * @param head
     * @return
     */
    private static ListNode reverseNodeList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            // 保留下一个节点
            ListNode next = current.next;
            // 当前节点指向前节点
            current.next = pre;
            // 前节点成为当前节点
            pre = current;
            // 让下一个节点成为当前节点
            current = next;
        }
        return pre;
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
        ListNode resultNode= reverseKGroup(listNode, 3);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }

    }

}

