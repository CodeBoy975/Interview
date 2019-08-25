package com.yao.leetcode;

/**
 * 描述： 链表
 *         1 反转一个单链表
 *         思路：
 *          （1）每次查看cur节点是否为NULL，如果是，则结束循环，获得结果
 *          （2）如果cur节点不是为NULL，则先设置临时变量next为cur的下一个节点
 *          （3）让cur的下一个节点变成指向pre，而后pre移动cur，cur移动到next
 *          （4）重复（1）（2）（3）
 *
 * @author pengjie_yao
 * @date 2019/7/15 22:46
 */
public class LinkedList {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
//        node1 =  reverseLinkedList(node1);
//        node1 = reverseLinkedList1(node1);
//        node1 = reverseList2(node1);
        node1 = reverseNodeList3(node1);

        while (node1 != null) {
            System.out.println(node1.data);
            node1 = node1.next;
        }

    }

    /**
     *  反转链表
     * @param node
     * @return
     */
    public static Node reverseLinkedList(Node node) {
        Node pre = null;
        Node cur = node;
        while (cur != null) {
            Node next = cur.next;
            // 将当前指针指向前节点
            cur.next = pre;
            // 将前节点移到当前节点
            pre = cur;
            // 当前节点继续移动到下一个节点作为当前节点
            cur = next;
        }
        return pre;
    }

    /**
     *  迭代的方式： 使用另外一个链表，遍历原链表，头插法插入
     * @param node
     * @return
     */
    public static Node reverseLinkedList1(Node node) {
        Node reverseNode = null;
        Node first = node;
        while (first != null) {
           // 保存第二个节点
            Node second = first.next;
            // 让节点指向要保存的节点处
            first.next = reverseNode;
            // 让反转节点重新成为
            reverseNode = first;
            first = second;
        }
        return reverseNode;
    }


    /**
     * 递归实现
     *
     * @param head
     * @return
     */
    public static Node reverseList2(Node head) {

        // 处理是单节点或空节点情况
        if (head == null || head.next == null) {
            return head;
        }
        // 将即将被调用的下一个节点分离，即将下一个调用的输入存在second里,即head为前节点
        Node second = head.next;
        // 将调用后的结果存储，这个结果就是最终结果。之后利用递归，调用刚才存好的输入
        Node reverseHead = reverseList2(second);
        // 上面一步的调用已经完成以second为首的链表的反转，所以现在second变成了反转完成后的尾节点
        // 把这个尾节点的next指向一开始输入的前驱，即head，完成整个链表反转
        second.next = head;
        // 最开始的头节点要变成尾节点，即在后面补null使链表终结
        head.next = null;
        return reverseHead;
    }


    /**
     *   反转链表
     * @param head
     * @return
     */
    public static Node reverseNodeList3(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node second = head.next;
        // 1 返回值 ： 返回的是已经反转后的链表
        // 2 返回的单位做了什么： 将链表进行反转
        Node node = reverseLinkedList(second);
        second.next = head;
        head.next = null;
        // 3 终止条件： 最后一个节点
        return node;

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


