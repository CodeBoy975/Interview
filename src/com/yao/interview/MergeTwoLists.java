package com.yao.interview;

/**
 * 描述： 合并两个有序的链表
 *
 * @author pengjie_yao
 * @date 2019/8/2 14:59
 */
public class MergeTwoLists {

    /**
     * 节点
     */
    public static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 非递归方式：合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 1.判空处理
        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 == null) {
            return null;
        }
        // 2.设置一个头指针的前节点，用来保存头节点的位置，方便返回结果
        ListNode preHead = new ListNode(-1);
        // 合并的链表指针，用来表示合并的节点处
        ListNode mergeList = preHead;
        while (l1 != null && l2 != null) {
            // 3.如果链表1的节点小于链表2，则将合并的节点指向链表1的节点，并让合并节点成为该节点
            if (l1.val < l2.val) {
                mergeList.next = l1;
                mergeList = l1;
                l1 = l1.next;
            } else {
                // 4.如果链表1的节点大于链表2的节点，则将合并的节点指向链表2的节点，并让合并节点成为该节点
                mergeList.next = l2;
                mergeList = l2;
                l2 = l2.next;
            }
        }
        // 5.如果链表1为空，链表2不为空，则直接将合并节点指向链表2的节点
        if (l1 == null && l2 != null) {
            mergeList.next = l2;
        } else if (l2 == null && l1 != null) {
            // 如果链表2为空，链表1不为空，则直接将合并节点指向链表1的节点
            mergeList.next = l1;
        }
        return preHead.next;
    }


    /**
     * 递归方式
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l2.next, l1);
            return l2;
        }

    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        listNode.next = listNode2;
        listNode2.next = listNode4;
        System.out.print("链表1：");
        print(listNode);

        listNode1.next = listNode3;
        listNode3.next = listNode5;
        System.out.print("链表2：");
        print(listNode1);

        ListNode resultNode = mergeTwoLists(listNode, listNode1);
        System.out.print("合并后的链表为：");
        print(resultNode);
        ListNode reverseNode = reverseNodeList(resultNode);
        System.out.print("反转后的链表为：");
        print(reverseNode);

    }

    /**
     * 单链表的反转
     *
     * @param head
     * @return
     */
    public static ListNode reverseNodeList(ListNode head) {
        // 1. 判空
        if (head == null) {
            return null;
        }
        // 2. 设置指针 前节点、当前节点、下一个节点，则每次让当前节点的指向前节点，下一个节点变成当前节点
        ListNode pre = null;
        ListNode currentNode = head;

        // 3. 遍历链表
        while (currentNode != null) {
            // 保留下一个节点
            ListNode next = currentNode.next;
            // 当前节点指向前一个节点
            currentNode.next = pre;
            // 前节点移动到当前节点
            pre = currentNode;
            // 当前节点成为下一个节点
            currentNode = next;
        }
        return pre;
    }

    /**
     * 遍历链表
     */
    public static void print(ListNode node) {
        if (node == null)
            return;
        ListNode printNode = node;
        while (printNode != null) {
            System.out.print(printNode.val + " ");
            printNode = printNode.next;
        }
        System.out.println();
    }
}
