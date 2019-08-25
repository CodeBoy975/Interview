package com.yao.leetcode;

import java.util.Stack;

/**
 * 描述： 用栈实现队列
 * 题目：用栈模拟一个队列，要求实现队列的两个基本操作: 入队、出队。
 *
 * @author pengjie_yao
 * @date 2019/7/14 11:31
 */
public class StackToQueue {

    private Stack<Integer> stackA = new Stack<Integer>();
    private Stack<Integer> stackB = new Stack<Integer>();

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.enQueue(1);
        stackToQueue.enQueue(2);
        stackToQueue.enQueue(3);
        System.out.println(stackToQueue.outQueue());
        System.out.println(stackToQueue.outQueue());
        stackToQueue.enQueue(4);
        System.out.println(stackToQueue.outQueue());
        System.out.println(stackToQueue.outQueue());
    }


    /**
     *  入队
     * @param element
     */
    public void enQueue(int element) {
        stackA.push(element);
    }

    /**
     *  出队
     * @return
     */
    public Integer outQueue() {
        // 1 A/B两栈都为空则没有元素
        if (stackB.isEmpty()) {
            if (stackA.isEmpty()) {
                return null;
            }
            // 2 如果栈B为空，则将栈A元素压入栈A中
            transfer();
        }
        // 3 弹出栈B的栈顶元素
        return stackB.pop();
    }

    /**
     *  将栈A的元素弹出压入栈B中
     */
    private void transfer() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }

}
