package com.yao.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述： 队列实现栈
 *
 * @author pengjie_yao
 * @date 2019/7/18 20:24
 */
public class QueueToStack {

    private static  Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }

    /**
     * 出栈： 直接将队头元素移出即可
     * @return
     */
    public static Integer pop( ) {
        if (!queue.isEmpty()) {
            return queue.remove();
        }
        return null;
    }

    /**
     *  入栈： 每次入栈，将入队的元素加入到队头
     * @param values
     */
    public static void push(int values) {
        queue.add(values);
        for (int i = 0; i < queue.size()-1; i++) {
            queue.add(queue.remove());
        }
    }
}
