package com.yao.leetcode;

import com.sun.javafx.image.IntPixelGetter;

import java.util.*;

/**
 * 描述： 滑动窗口最大值
 * <p>
 * 思路：
 *      解法一： 使用双端队列实现
 *      解法二： 使用优先队列(最大堆)
 *
 *
 * @author pengjie_yao
 * @date 2019/7/19 20:36
 */
public class MaxSlidingWindow {

    /**
     * 最大堆
     */
    private static PriorityQueue<Integer> priorityQueue = new PriorityQueue(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {

            return o2 - o1;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    });

    public static void main(String[] args) {

        int[] array = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] maxarray =  dequeueWindow(array,3);

        System.out.println(Arrays.toString(maxarray));
    }

   /* public static int[] maxSlidingWindow(int[] array, int k) {
        // 如果数组为空，则直接返回空数组
        if (array.length <= 0) {
            return new int[]{};
        }
        // 设置一个数组堆结果进行保存
        int[] maxArray = new int[array.length - k + 1];

        for (int i = 0; i < array.length; i++) {
            // 入最大堆
            priorityQueue.offer(array[i]);
            if (i >= k - 1) {
                // 获取堆顶元素放入结果数组
                maxArray[i - k + 1] = priorityQueue.peek();
                // 移除左窗口的元素
                priorityQueue.remove(array[i - k + 1]);
            }
        }

        return maxArray;
    }*/

    public static int[] maxSlidingWindow1(int[] array, int k) {
        if (array.length <= 0) {
            return new int[]{};
        }
        int[] result = new int[array.length - k + 1];
        // 双端队列方式
        Deque<Integer> deque = new ArrayDeque();
        // 维护一个双端队列1, 3, -1, -3, 5, 3, 6, 7}
        // 则刚开始，入队k个元素，则当进入
        for (int i = 0; i < array.length; i++) {
            // 删除队列右侧比它小的元素
            if (i >= k && (i - k + 1) > deque.peek()) {
                deque.remove();
            }
            // 从队列右侧开始，删除小于array[i]的元素
            while (!deque.isEmpty() && array[deque.peekLast()] < array[i]) {
                deque.removeLast();
            }
            deque.add(i);
            // 队列左侧最大值，加入结果
            if (i - k + 1 >= 0) {

                result[i - k + 1] = array[deque.peek()];
            }
        }
        return result;
    }


    /**
     * 优先队列： 最大堆
     *
     * @param array
     * @param k
     */
    public static int[] maxSlidingWindow(int[] array, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 1.堆数组为空进行判断
        if (array.length == 0) {
            return new int[]{};
        }
        // 结果数组，用来存储返回的结果集数组
        int[] maxArray = new int[array.length - k + 1];
        // 2. 遍历数组,并放入堆中
        for (int i = 0; i < array.length; i++) {
            // 将元素加入堆中
            priorityQueue.offer(array[i]);
            // 3. 当堆中的元素大于或者等于k的时候，将堆顶元素放入结果数组，并删除堆中元素
            if (i + 1 >= k) {
                maxArray[i - k + 1] = priorityQueue.peek();
                priorityQueue.remove(array[i - k+1]);
            }
        }
        return maxArray;
    }

    /**
     *  双端队列实现
     * @param array
     * @param k
     * @return
     */
    public static int[] dequeueWindow(int[] array, int k) {
        if (array.length == 0) {
            return new int[]{};
        }
        int[] maxArray = new int[array.length - k + 1];
        Deque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < array.length; i++) {
            // 刚开始左边元素的删除
            // 1.出队操作，当移入元素，则对应的元素位置应该出队
            if (i >= k && i - k + 1 > deque.peek()) {
                deque.remove();
            }

            // 2. 右移入判断，如果左边元素比右边元素小，则全部移出
            while (!deque.isEmpty()  && array[i] > array[deque.peekLast()]) {
                deque.removeLast();
            }
            // 3.将数组下标加入数组
            deque.add(i);
            // 4. 将值放入结果数组
            if (i - k + 1 >= 0) {
                maxArray[i-k+1] = array[deque.peek()];
            }

        }
        return maxArray;

    }
}
