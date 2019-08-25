package com.yao.interview;

import sun.awt.image.ImageWatched;

/**
 * 描述： 实现一个链表的增删改查
 *
 * @author pengjie_yao
 * @date 2019/8/2 9:44
 */
public class LinkList {

    Node head;


    public static void main(String[] args) throws Exception {

        LinkList linkList = new LinkList();
        // 新增
        System.out.println("新增节点1,2");
        linkList.add(1);
        linkList.add(2);
        System.out.print("链表为：");
        linkList.print();

        // 删除
        System.out.println("删除：末尾移除");
        linkList.remove();
        System.out.print("链表为：");
        linkList.print();
        System.out.println("新增节点3,5");
        linkList.add(3);
        linkList.add(5);
        System.out.print("链表为：");
        linkList.print();
        System.out.println("第1个位置后上插入节点4");
        linkList.insertNode(1,4);
        linkList.print();
    }

    /**
     * 新增
     *
     * @param val
     */
    public void add(int val) {
        // 1.判断链表是否为空
        if (head == null) {
            head = new Node(val);
        } else {
            // 将加的节点放到链表末尾去，用尾插法
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = new Node(val);
        }
    }

    /**
     * 删除最后一个节点
     */
    public void remove() {

        // 1.head判断是否为空
        if (head == null) {
            return;
        }
        // 2.找到要输出值的位置
        Node targeNode = head;
        Node pre = head;

        while (targeNode.next != null) {
            // 3.继续遍历
            pre = targeNode;
            targeNode = targeNode.next;
        }
        if (pre == head && pre.next == null) {
            head = null;
        } else {
            pre.next = null;
        }
    }


    /**
     * 遍历链表
     */
    public void print() {
        if (head == null)
            return;
        Node printNode = head;
        while (printNode != null) {
            System.out.print(printNode.val + " ");
            printNode = printNode.next;
        }
        System.out.println();
    }


    /**
     * 指定位置插入元素
     *
     * @param index
     * @param val
     */
    public void insertNode(int index, int val) throws Exception {
        // 1.判断插入元素是否超过边界,获取链表的长度
        int length = 0;
        Node node = head;
        Node pre = head;
        Node targeNode = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        if (index > length) {
            throw new Exception("插入元素超过链表的长度");
        }
        // 2. 找到插入的位置
        int i=1;
        while (i < index) {
            targeNode = targeNode.next;
            i++;
        }
        Node insertNode = new Node(val);
        // 插入
        insertNode.next = targeNode.next;
        targeNode.next = insertNode;
    }


    /**
     * 节点
     */
    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
