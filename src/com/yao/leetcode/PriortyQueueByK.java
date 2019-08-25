package com.yao.leetcode;

import java.util.PriorityQueue;

/**
 * 描述： 优先队列题目： 寻找数据流中的第K大元素
 *   思路： 基于最小堆实现
 *
 * @author pengjie_yao
 * @date 2019/7/18 21:20
 */
public class PriortyQueueByK {
    final PriorityQueue<Integer> priorityQueue;

    final int k;

    public PriortyQueueByK(int k, int[] array) {
        this.k = k;
        priorityQueue = new PriorityQueue<>(k);
        for (int i : array) {
            add(i);
        }
    }

    /**
     *  新增堆顶元素
     * @param n
     * @return
     */
    public int add(int n) {
        // 堆的元素个数小于k个元素的时候，加入堆
        if (priorityQueue.size() < k) {
            priorityQueue.offer(n);
        } else if (priorityQueue.peek() < n) {
            // 堆顶的元素小于要加入的元素，则表示堆顶的元素不是第k大的元素，则将堆顶元素去掉，新元素加入
            priorityQueue.poll();
            priorityQueue.offer(n);
        }
        // 返回堆顶元素
        return priorityQueue.peek();
    }



    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 5, 4, 20, 15};
        PriortyQueueByK priorityQueue = new PriortyQueueByK(1, array);
        // return 21
        priorityQueue.add(21);
        // return 22
        priorityQueue.add(22);
        // return 34
        priorityQueue.add(34);
    }
}
