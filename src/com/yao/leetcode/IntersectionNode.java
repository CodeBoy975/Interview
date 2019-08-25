package com.yao.leetcode;

import java.util.List;
import java.util.Stack;

/**
 * 描述： 求两个链表的相交节点
 *
 * @author pengjie_yao
 * @date 2019/8/3 16:30
 */
public class IntersectionNode {


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        // 1 2 3 4 5


        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(8);
        ListNode node12 = new ListNode(7);
        ListNode node13 = new ListNode(6);
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node2;
        // 9 8 7 6 3 4 5
//        getIntersectionNode(node, node10);
        ListNode node33 = new ListNode(1);
        ListNode node44 = new ListNode(1);
//        ListNode intersectionNode1 = getIntersectionNode1(node, node10);
        ListNode intersectionNode1 = getIntersectionNode2(node, node10);


        if (intersectionNode1 != null) {
            System.out.println(intersectionNode1.val);
        }
    }


    /**
     * 使用栈作为辅助栈的解法
     * 用到了辅助栈，时间辅助度为O(m+n)
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 1.判空
        if (headA == null || headB == null) {
            return null;
        }
        // 2.定义两个辅助栈，用来存储两个链表遍历的数据
        Stack<ListNode> stackA = new Stack<ListNode>();
        Stack<ListNode> stackB = new Stack<ListNode>();
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        // 3.遍历链表，存入栈中
        while (nodeA != null) {
            stackA.push(nodeA);
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            stackB.push(nodeB);
            nodeB = nodeB.next;
        }

        // 遍历栈中元素进行比较,从尾部开始，找到不同的节点处则返回结果
        ListNode pre = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() != stackB.peek()) {
                return pre;

            } else {
                pre = stackA.peek();
                stackA.pop();
                stackB.pop();
            }

        }
        return pre;
    }


    /**
     * 优化： 先求出链表的长度，然后让长的链表先走对应的步数，然后再同时走，再进行比较
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        // 1.判空
        if (headA == null || headB == null)
            return null;
        // 2.数组长度
        int lengthA = 0;
        int lengthB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        // 3.求出A/B长度
        while (nodeA != null) {
            lengthA++;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            lengthB++;
            nodeB = nodeB.next;
        }
        // 重新赋值
        nodeA = headA;
        nodeB = headB;
        // 4.判断谁的长度比较长，则让它先走
        if (lengthA < lengthB) {
            int distance = lengthB - lengthA;
            for (int i = 0; i < distance; i++) {
                nodeB = nodeB.next;
            }
        }else if(lengthA> lengthB) {
            int distance = lengthA - lengthB;
            for (int i = 0; i < distance; i++) {
                nodeA = nodeA.next;
            }
        }

        // 5. 两者同步前进并比较
        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return null;
    }

}
