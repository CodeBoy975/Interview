package com.yao.leetcode;

import com.sun.scenario.effect.impl.prism.PrImage;

/**
 * 描述： 动态规划
 * 题目：买卖股票问题： 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author pengjie_yao
 * @date 2019/7/15 22:05
 */
public class Dynamic {
    public static void main(String[] args) {

        int[] array = new int[]{7, 1, 5, 3, 6, 4};
//        int[] array = new int[]{1, 2, 3, 4, 5};
        int i = maxProfit1(array);
        System.out.println(i);
    }

    /**
     * 获取股票的最大收益
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 1. 对数组进行判断处理
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        // 2. 遍历数组，如果后一天的数值比前一天大，则前一天的卖出去

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                max = max + prices[i + 1] - prices[i];

            }
        }
        return max;
    }

    /**
     *  峰谷法
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        // 1. 判空
        if (prices.length == 0) {
            return 0;
        }

        // 2. 低谷值和峰谷默认都为第一个元素值
        int i = 0;
        int peek = prices[0];
        int valley = prices[0];
        int maxPrifit = 0;
        while (i < prices.length -1) {
            // 3. 查找低谷值
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            // 4. 查找峰值
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peek = prices[i];
            // 5. 计算收益
            maxPrifit = maxPrifit + peek - valley;
        }
        return maxPrifit;
    }
}
