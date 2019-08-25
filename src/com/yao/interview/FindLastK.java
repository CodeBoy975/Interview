package com.yao.interview;

import java.util.Stack;

/**
 * 描述： 查找链表的倒数第k个节点
 *
 * @author pengjie_yao
 * @date 2019/8/2 14:00
 */
public class FindLastK {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode lastKNode = findLastKNode1(node, 3);
        if (lastKNode != null) {
            System.out.println(lastKNode.val);
        }else {
            System.out.println("请检查一下输入的链表是否为控股或者k值是否大于链表长度");
        }

    }

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
     *  查找链表的第k个节点
     * @param head
     * @param k
     * @return
     */
    public static ListNode findLastKNode(ListNode head, int k){

        // 1.判空
        if (head == null || k == 0) {
            return null;
        }
        // 2.定义两个指针，分别为快指针和慢指针
        ListNode fast = head;
        ListNode slower = head;
        int count = 0;
        // 3.遍历链表，快指针先走k-1步后慢指针再走，如果快指针为空，则此时慢指针就是dik个节点
        while (fast != null) {
            if (count > k - 1) {
                slower = slower.next;
            }
            fast = fast.next;
            count++;
        }
        // 3.如果k是大于链表长度的话
        if(count < k) {
            return null;
        }
        // 4.返回节点值
        return slower;
    }

    /**
     *  使用辅助栈
     *  时间辅助度为O(n)
     * @param head
     * @param k
     * @return
     */
    public static ListNode findLastKNode1(ListNode head, int k) {
        // 1.判空
        if (head == null || k == 0) {
            return null;
        }

        // 2.定义栈，用来存储链表中的节点
        Stack<ListNode> stack = new Stack();
        ListNode node = head;

        // 3.遍历链表，将节点放入栈中
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        // 4. 中栈中遍历第k个节点
        while (k > 0) {
            node = stack.pop();
            k--;
        }
        return node;
    }

    }
