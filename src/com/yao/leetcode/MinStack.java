package com.yao.leetcode;

import java.util.Stack;

/**
 * 描述： 该栈带有出线(pop)、入栈(push)、取最小元素(getMin)3个方法。要保证3个方法的时间复杂度为O(1)
 * 思路： 采用两个栈的方式来实现，另外一个栈主要是用来存放最小栈。
 *          每次入栈，如果是主栈的最小值,则把该值也一样压入最小栈中。
 *          每次出栈，如果该值跟最小栈的栈顶元素一样，则将最小栈的栈顶也出栈
 *
 * @author pengjie_yao
 * @date 2019/7/13 11:03
 */
public class MinStack {

    private static Stack<Integer> mainStack = new Stack<Integer>();
    private static Stack<Integer> minStack = new Stack<Integer>();

    public static void main(String[] args) throws Exception {
        MinStack mainStack = new MinStack();
        mainStack.push(4);
        mainStack.push(9);
        mainStack.push(7);
        mainStack.push(3);
        mainStack.push(8);
        mainStack.push(5);
        // 入栈： 栈底： 4, 9, 7, 3, 8, 5 栈顶
        System.out.println(mainStack.getMin());
        mainStack.pop();
        mainStack.pop();
        mainStack.pop();
        // 此时  4, 9, 7
        System.out.println(mainStack.getMin());

    }


    /**
     *  获取最小值
     */
    public static Integer getMin( ) throws Exception{
        if (minStack.empty()) {
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }

    /**
     *  入栈
     * @param element
     */
    public static void push(int element) {
        mainStack.push(element);
        // 最小栈为空,则此时压入是第一个值 或者 最小栈的栈顶元素比压入的值还大
        if (minStack.empty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    /**
     * 出栈
     */
    public static Integer pop() {
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        return  mainStack.pop();
    }
}
